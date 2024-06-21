package jmu.zyu.jianglin.controller;

import jmu.zyu.jianglin.dao.Work;
import jmu.zyu.jianglin.service.FileService;
import jmu.zyu.jianglin.service.WorkService;
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
@RequestMapping("/work")
public class WorkController {

    @Autowired
    WorkService workService;

    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<?> uploadFile(
            @RequestPart("file") MultipartFile file,
            @RequestPart String workName,
            @RequestPart Long typeId
    ) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("请选择一个文件进行上传。");
        }

        try {
            String uploadFile = fileService.uploadFile(file, workName, true);
            Work work = new Work(workName, uploadFile, typeId);
            workService.addNewWork(work);
            return ResponseEntity.ok(work);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("上传失败。" + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Work> getWorkById(@PathVariable Long id) {
        return ResponseEntity.ok(workService.getWorkById(id));
    }

    @GetMapping("/image/{id}")
    @ResponseBody
    public ResponseEntity<?> getWorkImageById(@PathVariable Long id) throws IOException {
        byte[] imageBytes = fileService.getImageByteArray(workService.getWorkImagePathById(id));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(imageBytes.length);

        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Work>> getWorkList() {
        return ResponseEntity.ok(workService.getWorkList());
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<Long> addNewWork(@RequestBody Work work) {
        return ResponseEntity.ok(workService.addNewWork(work));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteWorkById(@PathVariable Long id) {
        workService.deleteWorkById(id);
    }

    @PutMapping("/recover/{id}")
    @ResponseBody
    public void recoverWorkById(@PathVariable Long id) {
        workService.recoverWorkById(id);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<Long> updateWorkById(@PathVariable Long id, @RequestBody Work newWorkInfo) {
        return ResponseEntity.ok(workService.updateWorkById(id, newWorkInfo));
    }
}