package com.example.springbootfileupload.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UploadController {
    Map<String, Object> result = new HashMap<>();
    @RequestMapping("/uploadFile")
    public Map<String, Object> upload(@RequestParam("attach") MultipartFile file) throws IOException{
        System.out.println("File name = " + file.getOriginalFilename());
        System.out.println("File type = " + file.getContentType());

        String filePath = "c:/";
        file.transferTo(new File(filePath + file.getOriginalFilename()));
        result.put("Success", true);
        return result;
    }
}
