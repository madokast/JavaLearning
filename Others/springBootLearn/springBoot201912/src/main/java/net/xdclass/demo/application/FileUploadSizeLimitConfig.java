package net.xdclass.demo.application;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/**
 * Description
 * 文件上传大小限制
 * <p>
 * Data
 * 2019/12/15 21:05
 *
 * @author zrx
 * @version 1.0
 */

@SpringBootConfiguration
public class FileUploadSizeLimitConfig {
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory multipartConfigFactory = new MultipartConfigFactory();
        //单个文件大小
        //exceeds its maximum permitted size of 1024 bytes.
        multipartConfigFactory.setMaxFileSize(DataSize.ofMegabytes(1));//硬编码 不可以啊

        //总请求大小
        multipartConfigFactory.setMaxRequestSize(DataSize.ofMegabytes(10));

        return multipartConfigFactory.createMultipartConfig();
    }
}
