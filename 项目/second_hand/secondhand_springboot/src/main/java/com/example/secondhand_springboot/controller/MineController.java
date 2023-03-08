package com.example.secondhand_springboot.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.example.secondhand_springboot.common.Result;
import com.example.secondhand_springboot.entity.Collects;
import com.example.secondhand_springboot.entity.Goods;
import com.example.secondhand_springboot.entity.Orders;
import com.example.secondhand_springboot.entity.Users;
import com.example.secondhand_springboot.service.IMineService;
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
@RequestMapping("/mine")
public class MineController {
    @Autowired
    IMineService mineService;

    @GetMapping("/u_id/{u_id}")
    public Result getByName(@PathVariable Integer u_id){
        Users users=mineService.getByName(u_id);
        return Result.success(users);
    }

    @GetMapping("aditmessage/{u_id}")
    public Result getMessageId(@PathVariable Integer u_id){
        Users users=mineService.getMessageId(u_id);
        return Result.success(users);
    }
    @PutMapping("aditmessage/update")
    public Result update(@RequestBody Users users){
        mineService.update(users);
        return Result.success();
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
            String url="http://localhost:9090/api/fabu/file/download/"+flag;
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


    @GetMapping("/collects/{u_id}")
    public Result getCollects(@PathVariable Integer u_id){
        List<Collects> collects=mineService.collects_list(u_id);
        return Result.success(collects);
    }

    @GetMapping("/goods/{u_id}")
    public Result getGoods(@PathVariable Integer u_id){
        List<Goods> goods=mineService.goods_list(u_id);
        return Result.success(goods);
    }
//     修改物品信息
    @GetMapping("/aditGoods/{g_id}")
    public Result getGoodsId(@PathVariable Integer g_id){
        Goods goods=mineService.getGoodsId(g_id);
        return Result.success(goods);
    }
    @PutMapping("/aditGoods/update")
    public Result updateGoods(@RequestBody Goods goods){
        mineService.updateByGoodsId(goods);
        return Result.success();
    }

//    删除物品信息
    @DeleteMapping("/aditGoods/delete/{g_id}")
    public Result deleteGoods(@PathVariable Integer g_id){
        mineService.deleteByGoodsId(g_id);
        return Result.success();
    }

    @GetMapping("/OrdersLoad/{u_id}")
    public Result list(@PathVariable Integer u_id){
        List<Orders> orders=mineService.orders_list(u_id);
        return Result.success(orders);
    }
//      查看订单信息
    @GetMapping("/getOrders/{o_id}")
    public Result getOrders(@PathVariable Integer o_id){
        Orders orders=mineService.getOrders(o_id);
        return Result.success(orders);
    }

    @DeleteMapping("/deleteOrders/{o_id}")
    public Result deleteOrders(@PathVariable Integer o_id){
        mineService.deleteOrders(o_id);
        return Result.success();
    }
    @PutMapping("/aditOrders/update")
    public Result updateOrders(@RequestBody Orders orders){
        mineService.updateOrders(orders);
        return Result.success();
    }



}
