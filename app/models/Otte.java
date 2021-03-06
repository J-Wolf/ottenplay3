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
    private Task[] tasks;
    private byte[] image;
    private String imagepath;

    public Otte(Long id, String name, String rasse, Task[] tasks) {
        this.id = id;
        this.name = name;
        this.rasse = rasse;
        this.tasks = tasks;
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

    public Task[] getTasks() {
        return tasks;
    }

    public void setTasks(Task[] tasks) {
        this.tasks = tasks;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }
}
