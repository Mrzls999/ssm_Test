package com.example.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

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

    /**
     * 文件下载
     * @throws Exception
     */
    @RequestMapping("/fileDownload")
    public ResponseEntity<byte[]> fileDownload(String fileName, HttpServletRequest request){
        System.out.println(fileName);
        ResponseEntity<byte[]> responseEntity = null;
        try {
            //通过绝对路径，得到文件资源输入流
            InputStream resourceAsStream = request.getServletContext().getResourceAsStream("/upload/" + fileName);
            if(resourceAsStream!=null){
                //设置响应体-文件资源
                byte[] body = IOUtils.toByteArray(resourceAsStream);
                //设置响应头-设置当前文件为附件，通知浏览器下载，别打开
                MultiValueMap<String,String> headers = new HttpHeaders();

                //解决文件名中文乱码问题
                String header = request.getHeader("User-Agent");
                if(header != null && header.contains("Firefox")) {
                    fileName = "=?utf-8?B?"+new BASE64Encoder().encode(fileName.getBytes(StandardCharsets.UTF_8))+"?=";
                }else {
                    fileName = URLEncoder.encode(fileName, "UTF-8");
                }

                headers.add("Content-Disposition","attachment;filename="+fileName);
                responseEntity = new ResponseEntity<>(body,headers, HttpStatus.OK);
            }else {
                System.out.println("资源不存在");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseEntity;
    }
}
