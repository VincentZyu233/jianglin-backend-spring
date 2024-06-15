package jmu.zyu.jianglin.service;

import jmu.zyu.jianglin.dao.TableInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableInfoServiceImpl implements TableInfoService {

    @Override
    public TableInfo getTableInfo(String tableName) {
        // 这里需要根据表名查询数据库或其他方式获取表的信息，并构建 TableInfo 对象返回
        // 由于这里只是示例，我将返回一个空的 TableInfo 对象
        return new TableInfo(tableName);
    }

    @Override
    public List<TableInfo> getTableInfoList() {
        // 这里可以根据具体情况获取所有表的信息，构建 TableInfo 对象列表返回
        // 由于这里只是示例，我将返回一个空的列表
        List<String> tableNames = getAllTableNames(); // 假设这是获取所有表名的方法
        List<TableInfo> tableInfoList = new ArrayList<>();
        for (String tableName : tableNames) {
            TableInfo tableInfo = getTableInfo(tableName);
            tableInfoList.add(tableInfo);
        }
        return tableInfoList;
    }

    // 这里定义一个示例方法，用于获取所有表名
    private List<String> getAllTableNames() {
        // 这里可以根据具体情况查询数据库获取所有表名，这里只是示例，返回一个固定的列表
        return List.of("product", "banner");
    }

}
