package com.tools.module.app.web;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import com.tools.common.constant.SystemConstant;
import com.tools.common.model.Result;
import com.tools.common.util.DateUtils;
import com.tools.common.util.FileUtils;
import com.tools.module.app.entity.AppImage;
import com.tools.module.app.service.AppImageService;
import com.tools.module.app.util.AliYunUtils;
import com.tools.module.app.util.MinIoUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 图床
 * 爪哇笔记：https://blog.52itstyle.vip
 */
@Api(tags ="图片管理")
@RestController
@RequestMapping("app/image")
public class ImageController {

    @Autowired
    private AppImageService imageService;
    @Autowired
    private MinIoUtils minIoUtil;
    @Autowired
    private AliYunUtils aliYunUtils;

    @Value("${file.path}")
    private String filePath;

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
                /**
                 * 年月日目录
                 */
                String fileDay = DateUtil.thisYear()+"/"+(DateUtil.thisMonth()+1)+"/"+DateUtil.thisDayOfMonth();
                String imagePath = SystemConstant.FILE + "/" + fileDay+"/"+fileName;
                String minFile = parentFile.getPath()+SystemConstant.SF_FILE_SEPARATOR+fileName;
                /**
                 * 入 minIo
                 */
                minIoUtil.putObject("file",fileDay+"/"+fileName,minFile);
                /**
                 * 入库
                 */
                AppImage image = new AppImage();
                image.setOriginalName(file.getOriginalFilename());
                image.setImagePath(imagePath);
                image.setImageSize(file.getSize()/1024 + "KB");
                image.setFileMd5(FileUtils.getMd5(file));
                image.setGmtCreate(DateUtils.getTimestamp());
                /**
                 * 鉴黄
                 */
                image.setPornStatus(SystemConstant.PORN_STATUS_NO);
                imageService.upload(image);
                return Result.ok(image);
            }else{
                return Result.error();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
    }

    @PostMapping("list")
    public Result list(AppImage image) {
        return imageService.list(image);
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
