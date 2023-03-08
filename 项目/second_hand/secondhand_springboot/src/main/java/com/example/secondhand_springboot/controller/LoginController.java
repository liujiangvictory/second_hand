package com.example.secondhand_springboot.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.example.secondhand_springboot.common.Result;
import com.example.secondhand_springboot.controller.dto.LoginDTO;
import com.example.secondhand_springboot.controller.request.LoginRequest;
import com.example.secondhand_springboot.entity.Login;
import com.example.secondhand_springboot.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    ILoginService loginService;
//     根据id查名字
    @GetMapping("/u_id/{u_id}")
    public Result getId(@PathVariable Integer u_id){
        Login admin=loginService.getId(u_id);
        return Result.success(admin);
    }

    @PostMapping("/userlogin")
    public Result login(@RequestBody LoginRequest loginRequest){
        LoginDTO login=loginService.login(loginRequest);
           return  Result.success(login);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
       Login login=loginService.getById(id);
        return Result.success(login);
    }

    @PostMapping("/register")
    public Result register(@RequestBody Login login){
        loginService.register(login);
        return Result.success();
    }

    @GetMapping("/u_name/{u_name}")
    public Result getByUserName(@PathVariable String u_name){
        Login admin=loginService.getByUserName(u_name);
        return Result.success(admin);
    }
    //上传
    //String userDir=System.getProperty("user.dir");//获取当前的项目的根目录
    private static final String BASE_FILE_PATH=System.getProperty("user.dir")+"/avatar/";
    @PostMapping("/file/upload")
    public Result uploadFile(MultipartFile file){
        String originalFilename=file.getOriginalFilename(); //得到上传时的文件名
        if(StrUtil.isBlank(originalFilename)){
            return Result.error("文件上传失败");
        }
        long flag=System.currentTimeMillis();//获取当前时间，毫秒
        String filePath=BASE_FILE_PATH + flag + "_" + originalFilename;
        try {
            FileUtil.mkParentDirs(filePath);//创建父级目录
            file.transferTo(FileUtil.file(filePath));
//            Admin currentAdmin= TokenUtils.getCurrentAdmin();
//            String token=TokenUtils.genToken(currentAdmin.getId().toString(),currentAdmin.getPassword(),15);
            String url="http://localhost:9090/api/login/file/download/"+flag;
            if(originalFilename.endsWith("png") || originalFilename.endsWith("jpg") || originalFilename.endsWith("pdf")){
                url+="?play=1";
            }
            return Result.success(url);
        }catch (Exception e){
            log.error("文件上传失败",e);
        }
        return Result.error("文件上传失败");
    }
    //下载
    @GetMapping("/file/download/{flag}")
    public void downloadFile(@PathVariable String flag,@RequestParam(required = false) String play, HttpServletResponse response){
        OutputStream os;
        List<String> fileNames=FileUtil.listFileNames(BASE_FILE_PATH);
        String fileName=fileNames.stream().filter(name -> name.contains(flag)).findAny().orElse("");
        try {
            if(StrUtil.isNotEmpty(fileName)){
                String realName=fileName.substring(fileName.indexOf("_")+1);
                if("1".equals(play)){
                    response.addHeader("Content-Disposition","inline;filename="+ URLEncoder.encode(realName,"UTF-8"));
                }else {
                    response.addHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(realName,"UTF-8"));
                }
                byte[] bytes=FileUtil.readBytes(BASE_FILE_PATH + fileName);
                os = response.getOutputStream();
                os.write(bytes);
                os.flush();
                os.close();
            }
        }catch (Exception e){
            log.error("文件下载失败",e);
        }
    }

    @PostMapping("/upAvatar")
    public Result upAvatar(@RequestBody Login login){
        loginService.upAvatarById(login);
        return Result.success();
    }
}
