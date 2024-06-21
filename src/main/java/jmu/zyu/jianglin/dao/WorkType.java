package jmu.zyu.jianglin.dao;

import jakarta.persistence.*;

@Entity
@Table(name="work_type")
public class WorkType {

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "category_name")
    private String category_name;

    @Lob
    @Column(name = "category_description")
    private String category_description;

    @Column(name = "deleted")
    private boolean deleted = false;

    public WorkType(String category_name, String category_description){
        this.category_name = category_name;
        this.category_description = category_description;
    }


    public WorkType(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_description() {
        return category_description;
    }

    public void setCategory_description(String category_description) {
        this.category_description = category_description;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
