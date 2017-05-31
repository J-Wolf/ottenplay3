package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by georg on 21.05.2017.
 */
@Entity
public class Task extends Model {

    @Id
    @Column(name = "task_id")

    private Long id;
    private String name;
    private Worker worker;
    private Otte otte;
    private int duration;

    @OneToMany(mappedBy = "task")
    private List<ProjectTask> projects;

    @Transient
    private String tmpWorker;

    @Transient
    private String tmpOtte;


    public static Finder<Long, Task> find = new Finder<Long, Task>(Task.class);

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

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Otte getOtte() {
        return otte;
    }

    public void setOtte(Otte otte) {
        this.otte = otte;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTmpWorker() {
        return tmpWorker;
    }

    public void setTmpWorker(String tmpWorker) {
        this.tmpWorker = tmpWorker;
    }

    public String getTmpOtte() {
        return tmpOtte;
    }

    public void setTmpOtte(String tmpOtte) {
        this.tmpOtte = tmpOtte;
    }

}
