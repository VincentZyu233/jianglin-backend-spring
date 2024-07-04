package jmu.zyu.jianglin.dao;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "appointment_time", nullable = false)
    private LocalDateTime appointment_time; // 预约时间

    @Column(name = "user_open_id", nullable = false)
    private String user_open_id; // 用户openid

    @Column(name = "deleted")
    private boolean deleted = false;


    public Appointment(){

    }

    public Appointment(LocalDateTime appointment_time, String user_open_id) {
        this.appointment_time = appointment_time;
        this.user_open_id = user_open_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(LocalDateTime appointment_time) {
        this.appointment_time = appointment_time;
    }

    public String getUser_open_id() {
        return user_open_id;
    }

    public void setUser_open_id(String user_open_id) {
        this.user_open_id = user_open_id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
