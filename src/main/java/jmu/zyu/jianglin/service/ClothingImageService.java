package jmu.zyu.jianglin.service;


import jmu.zyu.jianglin.dao.ClothingImage;

import java.util.List;

public interface ClothingImageService {

    ClothingImage getClothingImageById(Long id); // 根据id查找服装图片对象

    String getClothingImagePathById(Long id);

    List<ClothingImage> getAllClothingImages(); // 获取所有服装图片对象的列表

    Long addNewClothingImage(ClothingImage clothingImage); // 新增服装图片对象，返回新增对象的id

    void deleteClothingImageById(Long id); // 根据id删除服装图片对象

    void recoverClothingImageById(Long id); // 根据id恢复被删除的服装图片对象

    Long updateClothingImageById(Long oldId, ClothingImage newImageInfo); // 根据id更新服装图片对象信息，返回更新对象的id



}