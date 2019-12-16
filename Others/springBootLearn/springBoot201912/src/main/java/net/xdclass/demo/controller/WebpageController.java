package net.xdclass.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Description
 * 访问html
 * <p>
 * Data
 * 2019/12/15 19:53
 *
 * @author zrx
 * @version 1.0
 */

@Controller
public class WebpageController {

    /**
     * 映射到index.html
     *
     * <!DOCTYPE html>
     * <html lang="en">
     *
     * <head>
     * 	<meta charset="UTF-8">
     * 	<title>welcome</title>
     * </head>
     *
     * <body>
     * 	<h1>xdclass.net</h1>
     * </body>
     *
     * </html>
     *
     * @return
     */
    @GetMapping(path = "/getIndex")
    public Object index(){
        return "index";
    }
}
