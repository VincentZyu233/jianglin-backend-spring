package jmu.zyu.jianglin.service;

import jmu.zyu.jianglin.dao.Clothing;
import jmu.zyu.jianglin.dao.ClothingCategory;
import jmu.zyu.jianglin.dao.ClothingImage;
import jmu.zyu.jianglin.dao.ClothingCategoryMapping;
import jmu.zyu.jianglin.dao.ClothingImageMapping;

import java.util.List;

public interface ClothingService {

    Clothing getClothingById(Long id); // 根据id查找服装对象

    List<Clothing> getAllClothing(); // 获取所有服装对象的列表

    Long addNewClothing(Clothing clothing); // 新增服装对象，返回新增对象的id

    void deleteClothingById(Long id); // 根据id删除服装对象

    void recoverClothingById(Long id); // 根据id恢复被删除的服装对象

    Long updateClothingById(Long oldId, Clothing newClothingInfo); // 根据id更新服装对象信息，返回更新对象的id
}



