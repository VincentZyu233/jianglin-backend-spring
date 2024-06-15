package jmu.zyu.jianglin.controller;

import jmu.zyu.jianglin.dao.Banner;
import jmu.zyu.jianglin.service.BannerService;
import jmu.zyu.jianglin.service.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BannerController {

    @Autowired
    private BannerService bannerService;

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

    @PostMapping("/banner")
    @ResponseBody
    public Response<Long> addNewBanner(@RequestBody Banner banner){
        return Response.newSuccess(bannerService.addNewBanner(banner));
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
