package jmu.zyu.jianglin.service;


import jmu.zyu.jianglin.dao.ClothingCategory;

import java.util.List;

public interface ClothingCategoryService {

    ClothingCategory getClothingCategoryById(Long id); // 根据id查找服装分类对象

    List<ClothingCategory> getAllClothingCategories(); // 获取所有服装分类对象的列表

    Long addNewClothingCategory(ClothingCategory clothingCategory); // 新增服装分类对象，返回新增对象的id

    void deleteClothingCategoryById(Long id); // 根据id删除服装分类对象

    void recoverClothingCategoryById(Long id); // 根据id恢复被删除的服装分类对象

    Long updateClothingCategoryById(Long oldId, ClothingCategory newCategoryInfo); // 根据id更新服装分类对象信息，返回更新对象的id

    boolean existsById(Long id);
}
