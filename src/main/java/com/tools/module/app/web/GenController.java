package com.tools.module.app.web;

import cn.hutool.core.io.FileUtil;
import com.tools.common.constant.SystemConstant;
import com.tools.common.model.Result;
import com.tools.common.util.GenUtils;
import com.tools.module.app.model.AppGen;
import com.tools.module.app.service.AppGenService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 代码生成
 * 爪哇笔记：https://blog.52itstyle.vip
 */
@RestController
@RequestMapping("/app/gen")
public class GenController {

    @Autowired
    private AppGenService genService;

    @Autowired
    public Configuration configuration;

    @Value("${file.path}")
    private String filePath;

    /**
     * 列表
     * @param gen
     * @return
     */
    @PostMapping("/list")
    public Result list(AppGen gen) {
        return genService.list(gen);
    }

    /**
     * 获取字段
     * @param tableName
     * @return
     */
    @PostMapping("/getColumn")
    public Result getColumn(String tableName) {
        AppGen gen = new AppGen();
        gen.setTableName(tableName);
        List<AppGen> list = genService.getByTable(gen);
        return Result.ok(list);
    }

    /**
     * 生成代码
     * @param gen
     * @return
     * @throws IOException
     * @throws TemplateException
     */
    @PostMapping("/create")
    public Result create(@RequestBody AppGen gen) throws IOException, TemplateException {
        /**
         * 获取表字段以及注释
         */
        List<AppGen> list = genService.getByTable(gen);
        String name = gen.getTableName();
        String[] table =  StringUtils.split(name,"_");
        gen.setPrefix(table[0]);
        gen.setFunction(table[1]);
        gen.setEntityName(GenUtils.allInitialCapital(gen.getTableName()));
        list.stream().forEach(column-> {
            if(!column.equals("gmt_modified")){
                column.setEntityColumnName(GenUtils.secInitialCapital(column.getColumnName()));
            }
        });
        gen.setList(list);
        String baseFile = filePath+ SystemConstant.SF_FILE_SEPARATOR+"com"+
                SystemConstant.SF_FILE_SEPARATOR+ "tools"+
                SystemConstant.SF_FILE_SEPARATOR+ "module"+
                SystemConstant.SF_FILE_SEPARATOR+ gen.getPrefix()+SystemConstant.SF_FILE_SEPARATOR;
        /**
         * 后端代码
         */
        File entityFile = FileUtil.touch(baseFile+"entity"+
                SystemConstant.SF_FILE_SEPARATOR+gen.getEntityName()+".java");
        File repositoryFile = FileUtil.touch(baseFile+"repository"+
                SystemConstant.SF_FILE_SEPARATOR+gen.getEntityName()+"Repository.java");
        File serviceFile = FileUtil.touch(baseFile+"service"+
                SystemConstant.SF_FILE_SEPARATOR+gen.getEntityName()+"Service.java");
        File serviceImplFile = FileUtil.touch(baseFile+"service"+
                SystemConstant.SF_FILE_SEPARATOR+"impl"+SystemConstant.SF_FILE_SEPARATOR+
                gen.getEntityName()+"ServiceImpl.java");
        File controllerFile = FileUtil.touch(baseFile+"web"+
                SystemConstant.SF_FILE_SEPARATOR + gen.getEntityName() + "Controller.java");
        /**
         * 前端代码
         */
        String htmlPath =  filePath+
                SystemConstant.SF_FILE_SEPARATOR + "templates"+
                SystemConstant.SF_FILE_SEPARATOR + gen.getPrefix()+
                SystemConstant.SF_FILE_SEPARATOR + gen.getFunction()+SystemConstant.SF_FILE_SEPARATOR;
        File listFile = FileUtil.touch(htmlPath + "list.html");
        File formFile = FileUtil.touch(htmlPath + "form.html");
        /**
         * 生成静态页面
         */
        Template template = configuration.getTemplate("html/list.ftl");
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(
                template, gen);
        FileUtil.writeString(text,listFile,"UTF-8");
        template = configuration.getTemplate("html/form.ftl");
        text = FreeMarkerTemplateUtils.processTemplateIntoString(
                template, gen);
        FileUtil.writeString(text,formFile,"UTF-8");
        /**
         * 生成后端代码 repository
         */
        template = configuration.getTemplate("java/repository.ftl");
        text = FreeMarkerTemplateUtils.processTemplateIntoString(
                template, gen);
        FileUtil.writeString(text,repositoryFile,"UTF-8");
        /**
         * 生成后端代码 entity
         */
        template = configuration.getTemplate("java/entity.ftl");
        text = FreeMarkerTemplateUtils.processTemplateIntoString(
                template, gen);
        FileUtil.writeString(text,entityFile,"UTF-8");
        /**
         * 生成后端代码 service
         */
        template = configuration.getTemplate("java/service.ftl");
        text = FreeMarkerTemplateUtils.processTemplateIntoString(
                template, gen);
        FileUtil.writeString(text,serviceFile,"UTF-8");
        /**
         * 生成后端代码 service 实现
         */
        template = configuration.getTemplate("java/serviceImpl.ftl");
        text = FreeMarkerTemplateUtils.processTemplateIntoString(
                template, gen);
        FileUtil.writeString(text,serviceImplFile,"UTF-8");
        /**
         * 生成后端代码 controller 实现
         */
        template = configuration.getTemplate("java/controller.ftl");
        text = FreeMarkerTemplateUtils.processTemplateIntoString(
                template, gen);
        FileUtil.writeString(text,controllerFile,"UTF-8");
        return Result.ok();
    }

}
