package jmu.zyu.jianglin.service;


import jmu.zyu.jianglin.dao.ClothingCategoryMapping;

import java.util.List;

public interface ClothingCategoryMappingService {

    ClothingCategoryMapping getClothingCategoryMappingById(Long id); // 根据id查找服装分类映射对象

    List<ClothingCategoryMapping> getAllClothingCategoryMappings(); // 获取所有服装分类映射对象的列表

    Long addNewClothingCategoryMapping(ClothingCategoryMapping mapping); // 新增服装分类映射对象，返回新增对象的id

    void deleteClothingCategoryMappingById(Long id); // 根据id删除服装分类映射对象

    void recoverClothingCategoryMappingById(Long id); // 根据id恢复被删除的服装分类映射对象

    Long updateClothingCategoryMappingById(Long oldId, ClothingCategoryMapping newMappingInfo); // 根据id更新服装分类映射对象信息，返回更新对象的id
}