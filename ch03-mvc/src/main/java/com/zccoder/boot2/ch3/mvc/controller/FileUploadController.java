package com.zccoder.boot2.ch3.mvc.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * <br>
 * 标题: 文件上传控制器<br>
 * 描述: 处理文件上传<br>
 *
 * @author zc
 * @date 2018/03/09
 **/
@Controller
@RequestMapping("/upload")
public class FileUploadController {

    @PostMapping("/form")
    @ResponseBody
    public String handleFormUpload(@RequestParam("name") String name,
                                   @RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            InputStream ins = file.getInputStream();

            // 处理上传内容
            return "success";
        }
        return "failure";
    }
}
