package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by georg on 21.05.2017.
 */
@Entity
public class Project extends Model{
    @Id
    @Column(name="project_id")

    private Long id;
    private String name;
    private Customer customer;
    private int duration;

    @OneToMany(mappedBy = "project")
    private List<ProjectTask> tasks;

    @Transient
    private String tmpCustomer;

    public static Finder<Long, Project> find = new Finder<Long, Project>(Project.class);

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTmpCustomer() {
        return tmpCustomer;
    }

    public void setTmpCustomer(String tmpCustomer) {
        this.tmpCustomer = tmpCustomer;
    }

    public List<ProjectTask> getTasks() {
        return tasks;
    }

    public void setTasks(List<ProjectTask> tasks) {
        this.tasks = tasks;
    }
}
