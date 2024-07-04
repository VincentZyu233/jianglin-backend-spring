package jmu.zyu.jianglin.controller;

import jmu.zyu.jianglin.dao.WorkFavorite;
import jmu.zyu.jianglin.service.WorkFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/work_favorite")
public class WorkFavoriteController {

    private final WorkFavoriteService workFavoriteService;

    @Autowired
    public WorkFavoriteController(WorkFavoriteService workFavoriteService) {
        this.workFavoriteService = workFavoriteService;
    }

    @GetMapping("/{id}")
    public WorkFavorite getWorkFavoriteById(@PathVariable Long id) {
        return workFavoriteService.getWorkFavoriteById(id);
    }

    @GetMapping("/user/{userOpenId}")
    public List<WorkFavorite> getWorkFavoritesByUserOpenId(@PathVariable String userOpenId) {
        return workFavoriteService.getWorkFavoriteListByUserOpenId(userOpenId);
    }

    @GetMapping("/all")
    public List<WorkFavorite> getAllWorkFavorites() {
        return workFavoriteService.getWorkFavoriteList();
    }

    @PostMapping("/check_status")
    public ResponseEntity<?> checkStatus( @RequestBody WorkFavorite workFavorite ){
        List<WorkFavorite> duplicateList = workFavoriteService.checkDuplicate(workFavorite.getUser_open_id(), workFavorite.getWork_id());
        if ( duplicateList.isEmpty() ){
            return ResponseEntity.ok(false);
        } else {
            return ResponseEntity.ok(true);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewWorkFavorite(@RequestBody WorkFavorite workFavorite) {
        List<WorkFavorite> duplicateList = workFavoriteService.checkDuplicate(workFavorite.getUser_open_id(), workFavorite.getWork_id());
        if ( duplicateList.isEmpty() ){
            return ResponseEntity.ok( workFavoriteService.addNewWorkFavorite(workFavorite) );
        } else {
            return ResponseEntity.badRequest().body("same favorite or has already exist");
        }

    }

    @PostMapping("/remove")
    public ResponseEntity<?> removeOldWorkFavorite(@RequestBody WorkFavorite workFavorite){
        System.out.println("in removeOldWorkFavorite(): PARAMS: " + workFavorite);
        List<WorkFavorite> duplicateList = workFavoriteService.checkDuplicate(workFavorite.getUser_open_id(), workFavorite.getWork_id());
        if ( duplicateList.isEmpty() ){
            return ResponseEntity.badRequest().body("Favorite record does not exist");
        } else {
//            workFavoriteService.removeWorkFavoriteByUserOpenIdAndWorkId(workFavorite.getUser_open_id(), workFavorite.getWork_id());
            for ( WorkFavorite obj: duplicateList ){
                System.out.println("in removeOldWorkFavorite(): delete 收藏记录， id is: " + obj.getId());
                workFavoriteService.deleteWorkFavoriteById(obj.getId());
            }
            return ResponseEntity.ok( "Favorite record removed" );
        }
    }

    @DeleteMapping("/{id}")
    public void deleteWorkFavoriteById(@PathVariable Long id) {
        workFavoriteService.deleteWorkFavoriteById(id);
    }

    @PutMapping("/{id}")
    public Long updateWorkFavoriteById(@PathVariable Long id, @RequestBody WorkFavorite updatedWorkFavorite) {
        return workFavoriteService.updateWorkFavoriteById(id, updatedWorkFavorite);
    }
}
