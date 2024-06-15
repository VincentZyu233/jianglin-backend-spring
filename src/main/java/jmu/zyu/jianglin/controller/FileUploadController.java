package jmu.zyu.jianglin.controller;


import jmu.zyu.jianglin.service.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileUploadController {

    // 阿里云ubuntu下的data路径
    private final String baseDir = "/data";

    @PostMapping("/upload")
    @ResponseBody
    public Response<String> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "folder") String folder,
            @RequestParam(value = "fileName") String fileName
    ) {
        if (file.isEmpty()) {
            return Response.newFail("请选择一个文件进行上传。");
        }

        try {
            // 构建目标文件夹路径
            String uploadDir = baseDir + "/" + folder;
            File folderPath = new File(uploadDir);
            if (!folderPath.exists()) {
                folderPath.mkdirs();  // 如果目录不存在，创建目录
            }

            // 确定文件名
            String finalFileName = fileName + "_" + file.getOriginalFilename();

            // 构建上传目标路径
            Path targetPath = Paths.get(uploadDir, finalFileName);

            // 保存文件到服务器
            Files.copy(file.getInputStream(), targetPath);

            return Response.newSuccess("文件上传成功");
        } catch (IOException e) {
            return Response.newFail("上传失败。" + e.getMessage());
        }
    }
}
