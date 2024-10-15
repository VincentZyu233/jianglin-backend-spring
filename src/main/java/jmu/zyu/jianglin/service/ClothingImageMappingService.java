package jmu.zyu.jianglin.service;

import jmu.zyu.jianglin.dao.ClothingImageMapping;
import org.springframework.lang.NonNull;

import java.util.List;

public interface ClothingImageMappingService {

    ClothingImageMapping getClothingImageMappingById(Long id); // 根据id查找服装图片映射对象

    List<ClothingImageMapping> getAllClothingImageMappings(); // 获取所有服装图片映射对象的列表

    List<ClothingImageMapping> getImagesOfThisClothing( Long clothing_id );

    Long addNewClothingImageMapping(ClothingImageMapping mapping); // 新增服装图片映射对象，返回新增对象的id

    void deleteClothingImageMappingById(Long id); // 根据id删除服装图片映射对象

    void recoverClothingImageMappingById(Long id); // 根据id恢复被删除的服装图片映射对象

    Long updateClothingImageMappingById(Long oldId, ClothingImageMapping newMappingInfo); // 根据id更新服装图片映射对象信息，返回更新对象的id



}
