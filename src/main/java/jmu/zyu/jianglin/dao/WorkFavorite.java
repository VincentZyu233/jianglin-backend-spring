package jmu.zyu.jianglin.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "work_favorite")
public class WorkFavorite {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_open_id")
    private String user_open_id;

    @Column(name="work_id")
    private Long work_id;



//    public WorkFavorite(Long id, String user_open_id, Long work_id) {
//        this.id = id;
//        this.user_open_id = user_open_id;
//        this.work_id = work_id;
//    }

    public WorkFavorite( String user_open_id, Long work_id) {
        this.user_open_id = user_open_id;
        this.work_id = work_id;
    }

    public WorkFavorite(){

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

    public Long getWork_id() {
        return work_id;
    }

    public void setWork_id(Long work_id) {
        this.work_id = work_id;
    }

    @Override
    public String toString() {
        return "qwq, WorkFavorite{" +
                "id=" + id +
                ", user_open_id='" + user_open_id + '\'' +
                ", work_id=" + work_id +
                '}';
    }
}