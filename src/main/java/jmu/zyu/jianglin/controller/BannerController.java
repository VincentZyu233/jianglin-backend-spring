package jmu.zyu.jianglin.controller;

import jmu.zyu.jianglin.dao.Banner;
import jmu.zyu.jianglin.service.BannerService;
import jmu.zyu.jianglin.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    BannerService bannerService;

    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<?> uploadFile(
            @RequestPart ("file") MultipartFile file,
            @RequestPart String text
    ) {
        System.out.println("in banner controller,uploadFile()");
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("请选择一个文件进行上传。");
        }

        try {
            String uploadFile = fileService.uploadFile(file, text, "banner");
            Banner banner = new Banner(text, uploadFile);
            bannerService.addNewBanner(banner);
            return ResponseEntity.ok(banner);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("上传失败。" + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Banner> getBannerById(@PathVariable Long id){
        return ResponseEntity.ok(bannerService.getBannerById(id));
    }

    @GetMapping("/image/{id}")
    @ResponseBody
    public ResponseEntity<?> getBannerImageById(@PathVariable Long id) throws IOException {

//            System.out.println("ovo1 in getBannerImageById(): getBannerImagePathById(id)" + bannerService.getBannerImagePathById(id).toString() );

            byte[] imageBytes =
                    fileService.getImageByteArray(
                            bannerService.getBannerImagePathById(id)
                    );

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            headers.setContentLength(imageBytes.length);

            // 返回包含图片字节数组的 ResponseEntity
            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);

    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Banner>> getBannerList(){

        return ResponseEntity.ok(bannerService.getBannerList());
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<Long> addNewBanner(@RequestBody Banner banner){
        return ResponseEntity.ok(bannerService.addNewBanner(banner));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteBannerById(@PathVariable Long id){
        bannerService.deleteBannerById(id);
    }

    @PutMapping("/recover/{id}")
    @ResponseBody
    public void recoverBannerById(@PathVariable Long id){
        bannerService.recoverBannerById(id);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<Long> updateBannerById(@PathVariable Long id, @RequestBody Banner newBannerInfo){
        return ResponseEntity.ok(bannerService.updateBannerById(id, newBannerInfo));
    }



}
