package jmu.zyu.jianglin.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;

@Service
public class FileService {
    private final String baseDir = "./files";
    private final static String BANNER = "/banner";
    private final static String PRODUCT = "/product";
    private final static String WORK = "/work";

    public String uploadFile(MultipartFile file, String text, String type) throws IOException {
        String folderName;
        if ( type.equals("banner") ) folderName = BANNER;
        else if ( type.equals("product") ) folderName = PRODUCT;
        else if ( type.equals("work") ) folderName = WORK;
        else throw new IllegalArgumentException("illegal entity type(folder name)");

        // 构建目标文件夹路径
        Path uploadDir = Paths.get(baseDir,  "/", folderName);
        File folderPath = new File(uploadDir.toUri());

        if (!folderPath.exists())
            folderPath.mkdirs();  // 如果目录不存在，创建目录

        // 确定文件名
        String finalFileName = text + "_" + file.getOriginalFilename();

        // 构建上传目标路径
        Path targetPath = Paths.get(uploadDir.toString(), finalFileName);
        System.out.println("target path: "+ targetPath);

        // 保存文件到服务器
        Files.copy(file.getInputStream(), targetPath);

        return targetPath.toString();
    }

    public byte[] getImageByteArray(String fileName) throws IOException {
        // Construct full file path
        Path filePath = Paths.get(fileName);
        System.out.println("ovo2 filePath to uri:" + filePath.toUri());
        File file = Paths.get(filePath.toUri()).toFile();
        System.out.println("ovo file:" + file);

        byte[] imageBytes = Files.readAllBytes(filePath);

        return imageBytes;
    }
}
