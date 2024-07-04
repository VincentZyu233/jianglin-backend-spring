package jmu.zyu.jianglin.service;

import jmu.zyu.jianglin.dao.Appointment;

import java.util.List;

public interface AppointmentService {

    Appointment getAppointmentById(Long id); // 根据id查找Appointment对象

    List<Appointment> getAppointmentList(); // 获取所有Appointment对象的列表

    Long addNewAppointment(Appointment appointment); // 新增Appointment对象，返回新增对象的id

    void deleteAppointmentById(Long id); // 根据id删除Appointment对象

    void recoverAppointmentById(Long id); // 根据id恢复被删除的Appointment对象

    Long updateAppointmentById(Long oldId, Appointment newAppointmentInfo); // 根据id更新Appointment对象信息，返回更新对象的id

}
