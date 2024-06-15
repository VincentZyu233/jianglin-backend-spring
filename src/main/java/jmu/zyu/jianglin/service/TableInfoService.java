package jmu.zyu.jianglin.service;

import jmu.zyu.jianglin.dao.TableInfo;

import java.util.List;

public interface TableInfoService {

    TableInfo getTableInfo(String tablename );

    List<TableInfo> getTableInfoList();

}
