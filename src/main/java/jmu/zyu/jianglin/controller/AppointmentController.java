package jmu.zyu.jianglin.controller;

import jmu.zyu.jianglin.dao.Appointment;
import jmu.zyu.jianglin.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        if (appointment != null) {
            return ResponseEntity.ok(appointment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Appointment>> getAppointmentList() {
        return ResponseEntity.ok(appointmentService.getAppointmentList());
    }

    @PostMapping("/add")
    public ResponseEntity<Long> addNewAppointment(@RequestBody Appointment appointment) {
        return ResponseEntity.ok(appointmentService.addNewAppointment(appointment));
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadNewAppointment(@RequestParam LocalDateTime appointment_time, @RequestPart String user_open_id){
        Appointment appointment = new Appointment(appointment_time, user_open_id);
        appointmentService.addNewAppointment(appointment);
        return ResponseEntity.ok(appointment);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointmentById(@PathVariable Long id) {
        appointmentService.deleteAppointmentById(id);
    }

    @PutMapping("/recover/{id}")
    public void recoverAppointmentById(@PathVariable Long id) {
        appointmentService.recoverAppointmentById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Long> updateAppointmentById(@PathVariable Long id, @RequestBody Appointment newAppointmentInfo) {
        Long updatedId = appointmentService.updateAppointmentById(id, newAppointmentInfo);
        if (updatedId != null) {
            return ResponseEntity.ok(updatedId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
