package jmu.zyu.jianglin.service;

import jmu.zyu.jianglin.dao.Banner;

import java.util.List;

public interface BannerService {

    Banner getBannerById(Long id); // 根据id查找Banner对象

    List<Banner> getBannerList(); // 获取所有Banner对象的列表

    Long addNewBanner(Banner banner); // 新增Banner对象，返回新增对象的id

    void deleteBannerById(Long id); // 根据id删除Banner对象

    void recoverBannerById(Long id); // 根据id恢复被删除的Banner对象

    Long updateBannerById(Long oldId, Banner newBannerInfo); // 根据id更新Banner对象信息，返回更新对象的id
}
