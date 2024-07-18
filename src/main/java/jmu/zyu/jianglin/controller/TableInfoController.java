package jmu.zyu.jianglin.controller;


import jmu.zyu.jianglin.dao.TableInfo;
import jmu.zyu.jianglin.service.Response;
import jmu.zyu.jianglin.service.TableInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/tableinfo")
public class TableInfoController {

    @Autowired
    private TableInfoService tableInfoService;

    @GetMapping("/{tablename}")
    @ResponseBody
    public Response<TableInfo> getTableInfoByTablename(@PathVariable String tablename ){
        return Response.newSuccess(tableInfoService.getTableInfo(tablename));
    }

    @GetMapping("/all")
    @ResponseBody
    public Response<List<TableInfo>> getTableInfoList(){
        return Response.newSuccess(tableInfoService.getTableInfoList());
    }

}
