package com.tools.module.app.service;


import com.tools.common.model.Result;
import com.tools.module.app.entity.AppTask;
import org.quartz.SchedulerException;

public interface AppTaskService {

    Result listQuartzEntity(AppTask task) throws SchedulerException;
    
    void save(AppTask task) throws Exception;

    void delete(AppTask task) throws SchedulerException;

    void resume(AppTask task) throws SchedulerException;

    long count();
}
