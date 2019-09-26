package com.smart.ResourceLearn;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 比Java原生file更好的资源读取其
 */

@Service
public class ResourceLearn {
    public void learn() {
        Resource resource = new ClassPathResource("aResource.txt");
        System.out.println("resource.exists() = " + resource.exists());
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            resource.getInputStream(), "UTF-8"
                    ));

            String s = null;
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
            }

            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
