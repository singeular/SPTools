package com.tools.module.app.web;

import com.tools.common.config.AbstractController;
import com.tools.common.model.Result;
import com.tools.module.app.entity.AppTask;
import com.tools.module.app.service.AppTaskService;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 任务调度
 * 爪哇笔记：https://blog.52itstyle.vip
 */
@RestController
@RequestMapping("/app/task")
public class TaskController extends AbstractController {

    @Autowired
    private Scheduler scheduler;
    @Autowired
    private AppTaskService taskService;

    /**
     * 新增
     * @param task
     * @return
     */
    @PostMapping("/save")
    public Result save(AppTask task){
        try {
            taskService.save(task);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
        return Result.ok();
    }

    /**
     * 任务列表
     * @param task
     * @return
     */
    @PostMapping("/list")
    public Result list(AppTask task) {
        try {
            return taskService.listQuartzEntity(task);
        } catch (SchedulerException e) {
            e.printStackTrace();
            return Result.error();
        }
    }

    @PostMapping("/trigger")
    public  Result trigger(AppTask task) {
        try {
            JobKey key = new JobKey(task.getName(),task.getGroup());
            scheduler.triggerJob(key);
        } catch (SchedulerException e) {
            e.printStackTrace();
            return Result.error();
        }
        return Result.ok();
    }

    /**
     * 执行/停止
     * @param task
     * @return
     */
    @PostMapping("/resume")
    public  Result resume(AppTask task) {
        try {
            taskService.resume(task);
        } catch (SchedulerException e) {
            e.printStackTrace();
            return Result.error();
        }
        return Result.ok();
    }

    /**
     * 删除
     * @param task
     * @return
     */
    @PostMapping("/delete")
    public  Result delete(AppTask task) {
        try {
            taskService.delete(task);
        } catch (Exception e) {
            return Result.error();
        }
        return Result.ok();
    }
}
