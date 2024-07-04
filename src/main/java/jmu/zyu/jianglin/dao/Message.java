package jmu.zyu.jianglin.dao;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="user_open_id", nullable = false)
    private String user_open_id;

    @Column(name = "message_content", columnDefinition = "TEXT")
    private String message_content;

    @Column(name = "message_time")
    private LocalDateTime message_time;

    @Column(name = "deleted", columnDefinition = "BOOLEAN DEFAULT false")
    private boolean deleted = false;

    public Message(String user_open_id, String message_content, LocalDateTime message_time) {
        System.out.println("ovo 带参数的构造函数");
        this.user_open_id = user_open_id;
        this.message_content = message_content;
        this.message_time = message_time;
    }

    public Message(){
        System.out.println("ovo 无参数的构造函数");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_open_id() {
        return user_open_id;
    }

    public void setUser_open_id(String user_open_id) {
        this.user_open_id = user_open_id;
    }

    public String getMessage_content() {
        return message_content;
    }

    public void setMessage_content(String message_content) {
        this.message_content = message_content;
    }

    public LocalDateTime getMessage_time() {
        return message_time;
    }

    public void setMessage_time(LocalDateTime message_time) {
        this.message_time = message_time;
    }

    public boolean isDeleted() {
        System.out.println("ovo deleted 的getter");
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        System.out.println("ovo deleted 的setter");

        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", user_open_id='" + user_open_id + '\'' +
                ", message_content='" + message_content + '\'' +
                ", message_time=" + message_time +
                ", deleted=" + deleted +
                '}';
    }
}



