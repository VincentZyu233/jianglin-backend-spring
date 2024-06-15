package jmu.zyu.jianglin.controller;

import jmu.zyu.jianglin.dao.Banner;
import jmu.zyu.jianglin.service.BannerService;
import jmu.zyu.jianglin.service.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @Autowired
    private RestTemplate restTemplate; // 注入 RestTemplate

    @GetMapping("/banner/{id}")
    @ResponseBody
    public Response<Banner> getBannerById(@PathVariable Long id){
        return Response.newSuccess(bannerService.getBannerById(id));
    }

    @GetMapping("/banner/all")
    @ResponseBody
    public Response<List<Banner>> getBannerList(){
        return Response.newSuccess(bannerService.getBannerList());
    }

//    @PostMapping("/banner")
//    @ResponseBody
//    public Response<Long> addNewBanner(@RequestBody Banner banner){
//        return Response.newSuccess(bannerService.addNewBanner(banner));
//    }

    @PostMapping("/banner")
    @ResponseBody
    public Response<Long> addNewBanner(@PathVariable String text, @RequestParam("file") MultipartFile file){
        if (file.isEmpty())
            return Response.newFail("请选择一个文件进行上传。");

        try {
            String path = restTemplate.postForObject("/upload?folder={folder}&fileName={fileName}", file, String.class, "banner", text);
            
            Banner newBanner = new Banner();
            newBanner.setText(text);
            newBanner.setImagePath(path); // 设置上传后的文件路径

            return Response.newSuccess(bannerService.addNewBanner(newBanner));
        } catch (Exception e) {
            return Response.newFail("上传失败。" + e.getMessage());
        }
    }

    @DeleteMapping("/banner/{id}")
    @ResponseBody
    public void deleteBannerById(@PathVariable Long id){
        bannerService.deleteBannerById(id);
    }

    @PutMapping("/banner/recover/{id}")
    @ResponseBody
    public void recoverBannerById(@PathVariable Long id){
        bannerService.recoverBannerById(id);
    }

    @PutMapping("/banner/update/{id}")
    @ResponseBody
    public Response<Long> updateBannerById(@PathVariable Long id, @RequestBody Banner newBannerInfo){
        return Response.newSuccess(bannerService.updateBannerById(id, newBannerInfo));
    }
}
