package jmu.zyu.jianglin.dao;

import jakarta.persistence.*;

@Entity
@Table(name="work")
public class Work {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="work_name")
    private String work_name;

    @Column(name="image_path")
    private String image_path;

    @Column(name="type_id")
    private Long type_id;

    @Column(name = "deleted")
    private boolean deleted = false;

    public Work(String work_name, String image_path, Long type_id ){
        this.work_name = work_name;
        this.image_path = image_path;
        this.type_id = type_id;
    }

    public Work(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWork_name() {
        return work_name;
    }

    public void setWork_name(String work_name) {
        this.work_name = work_name;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public Long getType_id() {
        return type_id;
    }

    public void setType_id(Long type_id) {
        this.type_id = type_id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
