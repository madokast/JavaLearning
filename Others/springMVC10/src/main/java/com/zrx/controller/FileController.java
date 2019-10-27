package com.zrx.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * 文件上传
 */

@Controller
@RequestMapping(path = "/file")
public class FileController {
    /**
     * 跨服务器的文件上传
     * 需要一个文件存储服务器~
     *
     * 请求 发送到应用服务器 ， 若需要上传图片，
     */
    @RequestMapping(path="/test3")
    public ModelAndView test3(MultipartFile upload21)throws Exception{
        System.out.println("跨服务器上传");

        //文件服务器路径
        final String serverPath = "http://localhost:9090/uploadFile/";

        //文件名
        final String filename = UUID.randomUUID().toString().replace("-","")
                + upload21.getOriginalFilename();

        //创捷客户端对象
        final Client client = Client.create();

        //连接用户服务器 文件也来了
        final String sourcePath = serverPath + filename;
        final WebResource webResource = client.resource(sourcePath);

        //上传文件
        webResource.put(upload21.getBytes());

        // view
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("imgFile",sourcePath);
        modelAndView.setViewName("success");
        return modelAndView;
    }


    /**
     * StringMVC文件上传方法
     * 利用文件解析器，这是controller方法就可以直接使用upload对象
     * 名字 upload21 必须和表单一致
     *
     * <!--    文件解析器 用于上传文件-->
     *     <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
     *         <property name="maxUploadSize" value="10485760"/>
     *     </bean>
     *
     *
     * @return
     */
    @RequestMapping(path = "/test2")
    public ModelAndView test2(MultipartFile upload21,HttpServletRequest request)throws Exception{
        System.out.println("springMvc");

        //准备
        final String path = "/uploads/";
        //使用file upload spi帮我们完成文件上传
        //指定上传位置
        final String uploadsPath = request.getSession().getServletContext().getRealPath(path);
        System.out.println("uploadsPath = " + uploadsPath);
        final File uploadsPathFile = new File(uploadsPath);
        if(!uploadsPathFile.exists()){
            uploadsPathFile.mkdirs();
        }

        String filename = upload21.getOriginalFilename();
        final String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid+filename;
        upload21.transferTo(new File(uploadsPathFile,filename));// KEY

        // view
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("imgFile",path+filename);
        modelAndView.setViewName("success");
        return modelAndView;
    }


    /**
     * 传统的文件上传解析方法
     * @return
     */
    @RequestMapping(path = "/test")
    public String test(HttpServletRequest request, HttpServletResponse response)throws Exception{
        final String path = "/uploads/";
        //使用file upload spi帮我们完成文件上传
        //指定上传位置
        final String uploadsPath = request.getSession().getServletContext().getRealPath(path);
        System.out.println("uploadsPath = " + uploadsPath);
        final File uploadsPathFile = new File(uploadsPath);
        if(!uploadsPathFile.exists()){
            uploadsPathFile.mkdirs();
        }

        //拿到一些工具
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        //解析request
        if(!ServletFileUpload.isMultipartContent(request)){
            System.out.println("表单不是Multipart类型");
        }
        List<FileItem> fileItems = servletFileUpload.parseRequest(request);
        System.out.println("fileItems = " + fileItems);
        for (FileItem fileItem : fileItems) {
            //判断是上传文件项，还是普通表单项
            if(fileItem.isFormField()){
                //普通表单项
                final String name = fileItem.getFieldName();
                final String value = fileItem.getString();
                System.out.println(name+"="+value);
            }else {
                //上传文件项
                System.out.println("上传文件项fileItem = " + fileItem);
                //名字
                String fileName = fileItem.getName();
                System.out.println("fileName = " + fileName);
                //上传
                final File file = new File(uploadsPath, fileName);
                fileItem.write(file);
                request.setAttribute("imgFile",path+fileName);
                //删除临时文件
                fileItem.delete();
            }
        }

        System.out.println("over");

        return "success";
    }
}
