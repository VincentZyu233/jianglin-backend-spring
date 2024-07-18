package jmu.zyu.jianglin.controller;

import jmu.zyu.jianglin.dao.WorkType;
import jmu.zyu.jianglin.service.WorkTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/work_type")
public class WorkTypeController {

    @Autowired
    WorkTypeService workTypeService;

    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<Long> addNewWorkType(@RequestPart String category_name, @RequestPart String category_description){
        return ResponseEntity.ok(workTypeService.addNewWorkType(new WorkType(category_name, category_description)));
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<Long> addNewWorkType(@RequestBody WorkType workType){
        return ResponseEntity.ok(workTypeService.addNewWorkType(workType));
    }


    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<WorkType> getWorkTypeById(@PathVariable Long id){
        return ResponseEntity.ok(workTypeService.getTypeById(id));
    }


    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<WorkType>> getWorkTypeList() {
        return ResponseEntity.ok(workTypeService.getWorkTypeList());
    }


    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteWorkTypeById(@PathVariable Long id){
        workTypeService.deleteWorkTypeById(id);
    }

    @PutMapping("/recover/{id}")
    @ResponseBody
    public void recoverWorkTypeById(@PathVariable Long id){
        workTypeService.recoverWorkTypeById(id);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<Long> updateWorkTypeById(@PathVariable Long id, @RequestBody WorkType newWorkTypeInfo){
        return ResponseEntity.ok(workTypeService.updateWorkTypeById(id, newWorkTypeInfo));
    }


}
