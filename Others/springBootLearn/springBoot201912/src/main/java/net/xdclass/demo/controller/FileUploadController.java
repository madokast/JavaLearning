package net.xdclass.demo.controller;

import net.xdclass.demo.domain.FileUploadState;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

/**
 * Description
 * 文件上次
 * 文件事务流
 * multipart file
 *
 * <p>
 * Data
 * 2019/12/15 20:04
 *
 * @author zrx
 * @version 1.0
 */

@RestController
public class FileUploadController {

    private static final String filePath = "D:\\Documents\\GitHub\\JavaLearning\\Others\\springBootLearn\\springBoot201912\\src\\main\\resources\\static\\img";

    /**
     * {"code":1,"info":"文件上次成功","otherInfo":"{后缀名=.png, 文件名=leetcode.png, 文件大小=9483}"}
     *
     * @param file MultipartFile
     * @return fileUploadState
     */
    @PostMapping(path = "upload")
    public Object upload(@RequestParam("head_img")MultipartFile file){
        HashMap<String,String> map = new HashMap<>();
        //一些文件信息

        map.put("文件大小",file.getSize()+"");

        String filename = file.getOriginalFilename();

        map.put("文件名",filename);

        if(filename==null){
            filename = "default.unknown";
        }

        final int lastIndexOf = filename.lastIndexOf(".");
        String suffixName;
        if(lastIndexOf==-1){
            suffixName = ".unknown";
        }else {
            suffixName = filename.substring(lastIndexOf);
        }

        map.put("后缀名",suffixName);

        final FileUploadState fileUploadState = new FileUploadState();
        fileUploadState.setOtherInfo(map.toString());

        //下面保存文件
        filename = UUID.randomUUID() + suffixName;
        File dest = new File(filePath,filename);

        try {
            file.transferTo(dest);
            fileUploadState.setCode(1);
            fileUploadState.setInfo("文件上次成功");
        }catch (Exception e){
            fileUploadState.setCode(1);
            fileUploadState.setInfo("文件上次成功");
            e.printStackTrace();
        }


        return fileUploadState;
    }
}
