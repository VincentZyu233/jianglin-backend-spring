package jmu.zyu.jianglin.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
    private final static String BANNER = "./banner";
    private final static String PRODUCT = "./product";

    public String uploadFile(MultipartFile file, String text, boolean banner) throws IOException {
        String baseDir = banner ? BANNER : PRODUCT;
        String fileName = text;

        // 构建目标文件夹路径
        Path uploadDir = Paths.get(baseDir,  "/", fileName);
        File folderPath = new File(uploadDir.toUri());

        if (!folderPath.exists()) {
            folderPath.mkdirs();  // 如果目录不存在，创建目录
        }

        // 确定文件名
        String finalFileName = fileName + "_" + file.getOriginalFilename();

        // 构建上传目标路径
        Path targetPath = Paths.get(uploadDir.toString(), finalFileName);

        // 保存文件到服务器
        Files.copy(file.getInputStream(), targetPath);

        return targetPath.toString();
    }
}
