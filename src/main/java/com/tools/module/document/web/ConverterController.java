package com.tools.module.document.web;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import com.tools.common.config.AbstractController;
import com.tools.common.constant.SystemConstant;
import com.tools.common.model.Result;
import io.swagger.annotations.Api;
import org.jodconverter.core.DocumentConverter;
import org.jodconverter.core.office.OfficeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;

@Api(tags ="文档管理")
@RestController
@RequestMapping("document")
public class ConverterController extends AbstractController {

    @Value("${file.path}")
    private String filePath;

    @Resource
    private DocumentConverter documentConverter;

    /**
     * 文件上传
     */
    @RequestMapping("/upload")
    public Result upload(MultipartFile file) {
        try {
            if(file!=null){
                File parentFile = createParentFile();
                String fileName = file.getOriginalFilename();
                String suffix = fileName.substring(fileName.lastIndexOf("."));
                String uuid = IdUtil.simpleUUID();
                fileName = uuid + suffix;
                File imageFile = new File(parentFile,fileName);
                FileUtil.writeFromStream(file.getInputStream(), imageFile);
                return Result.ok();
            }else{
                return Result.error();
            }
        } catch (Exception e) {
            return Result.error();
        }
    }

    /**
     * 文件上传
     */
    @RequestMapping("converter")
    public Result converter() {
        try {
            documentConverter
                    .convert(new File("F:\\前端.txt"))
                    .to(new File("E:\\home\\1.pdf")).execute();
        } catch (OfficeException e) {
            logger.error("转换失败{}",e);
            return Result.error();
        }
        return Result.ok();
    }

    /**
     * 创建多级文件夹
     * @return
     */
    public File createParentFile(){
        File parentFile = new File(filePath+ SystemConstant.SF_FILE_SEPARATOR+ DateUtil.thisYear());
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        parentFile = new File(parentFile,(DateUtil.thisMonth()+1)+"");
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        parentFile = new File(parentFile,DateUtil.thisDayOfMonth()+"");
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        return parentFile;
    }
}
