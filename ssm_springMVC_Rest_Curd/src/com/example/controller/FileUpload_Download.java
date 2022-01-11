package com.example.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;

/**
 * @author zls
 * @date 2022/1/11 11:13:42
 * @description XXX
 */
@Controller
public class FileUpload_Download {

    /**
     * 文件上传
     * @param multipartFile
     * @param desc
     * @param session
     * @throws Exception
     */
    @RequestMapping("/fileUpload")
    public String fileUpload(@RequestParam("desc")String desc,
                             @RequestParam("file")MultipartFile multipartFile,
                             HttpSession session) throws Exception {//此处抛出了异常，应该要处理的，暂时不写
        System.out.println(multipartFile+":"+ desc);
        System.out.println("写学习".equals(desc));
        String realPath = session.getServletContext().getRealPath("/upload");//获得upload的真实路径
        File file1 = new File(realPath);
        if(!file1.exists()){//如果文件夹不存在，则创建
            if(!file1.mkdir()){//如果没有创建成功
                throw new Exception("上传文件夹没有创建成功");
            }
        }//创建文件夹成功后
        String filename = multipartFile.getOriginalFilename();//xxx.jpg等
        File file2 = new File(realPath+File.separator+filename);
        multipartFile.transferTo(file2);
        return "success";
    }
}
