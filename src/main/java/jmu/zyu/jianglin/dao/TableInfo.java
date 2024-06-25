package jmu.zyu.jianglin.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableInfo {

    private String tableName;
    private List<Map<String, String>> tableInfo;

    public TableInfo(String tableName) {
        this.tableName = tableName;
        this.tableInfo = new ArrayList<>();

//        SELECT * FROM information_schema.columns WHERE table_name = 'banner' AND table_schema = 'jianglin';

        String query = "SELECT * FROM information_schema.columns WHERE table_name = ? AND table_schema = 'jianglin' ";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jianglin", "root", "diding2014");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, tableName);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();

            while (resultSet.next()) {
                Map<String, String> columnInfo = new HashMap<>();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    String columnName = metaData.getColumnName(i);
                    String columnValue = resultSet.getString(columnName);
                    // 注意：这里可能需要根据数据类型进行不同的处理，比如日期、数字等
                    columnInfo.put(columnName, columnValue);
                }
                tableInfo.add(columnInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Getter methods for tableName and tableInfo

    public String getTableName() {
        return tableName;
    }

    public List<Map<String, String>> getTableInfo() {
        return tableInfo;
    }
}