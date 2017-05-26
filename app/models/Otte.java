package models;

import com.avaje.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by georg on 21.05.2017.
 */
@Entity
public class Otte extends Model{
    @Id
    @Column(name="otte_id")

    private Long id;
    private String name;
    private String rasse;
    private Task task;

    public Otte(Long id, String name, String rasse, Task task) {
        this.id = id;
        this.name = name;
        this.rasse = rasse;
        this.task = task;
    }

    public static Finder<Long, Otte> find = new Finder<Long, Otte>(Otte.class);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRasse() {
        return rasse;
    }

    public void setRasse(String rasse) {
        this.rasse = rasse;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
