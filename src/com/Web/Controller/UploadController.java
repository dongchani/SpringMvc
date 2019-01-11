package com.Web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
@Controller
public class UploadController {

    @PostMapping("/upload")
   // 使用@RequestParam在参数名字跟表单name不一样的时候
        public String upload(MultipartFile file, HttpServletRequest request) throws  Exception{
        System.out.println("文件名："+file.getName());

        System.out.println("orginalFileName"+file.getOriginalFilename()); //原始名 还可以打点很多
        System.out.println("size"+file.getSize());


        String uploadDirectory=request.getServletContext().getRealPath("/upload");
        File newFile= new File(uploadDirectory);
        if (!newFile.exists()){
            newFile.mkdirs();
        }
        String newFilePath = uploadDirectory+"/"+file.getOriginalFilename();
       // 将收到的文件传输到给定的目标文件。
        file.transferTo(new File(newFilePath));
        return "index";
         }
 /*  @PostMapping("/upload")
    public  String upload(MultipartFile file,HttpServletRequest request) throws  Exception{
        String uploadDi=request.getServletContext().getRealPath("/upload");
        File newFile=new File(uploadDi);
        if (!newFile.exists()){
            newFile.mkdirs();
        }
        String newFilePatch=uploadDi+"/"+file.getOriginalFilename();
        file.transferTo(new File(newFilePatch));
        return  "index";*/
    }


