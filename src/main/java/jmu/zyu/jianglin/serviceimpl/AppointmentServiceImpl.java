package jmu.zyu.jianglin.serviceimpl;

import jmu.zyu.jianglin.dao.Appointment;
import jmu.zyu.jianglin.jparepo.AppointmentRepository;
import jmu.zyu.jianglin.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment getAppointmentById(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        return appointment.orElse(null);
    }

    @Override
    public List<Appointment> getAppointmentList() {
        return appointmentRepository.findAll();
    }

    @Override
    public Long addNewAppointment(Appointment appointment) {
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return savedAppointment.getId();
    }

    @Override
    public void deleteAppointmentById(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public void recoverAppointmentById(Long id) {
        appointmentRepository.recoverById(id);
    }

    @Override
    public Long updateAppointmentById(Long oldId, Appointment newAppointmentInfo) {
        Optional<Appointment> existingAppointment = appointmentRepository.findById(oldId);
        if (existingAppointment.isPresent()) {
            Appointment appointment = existingAppointment.get();

            appointment.setAppointment_time(newAppointmentInfo.getAppointment_time());
            appointment.setUser_open_id(newAppointmentInfo.getUser_open_id());

            appointmentRepository.save(appointment);
            return appointment.getId();
        } else {
            return null;
        }
    }
}
