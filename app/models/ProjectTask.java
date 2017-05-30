package models;

import com.avaje.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * Created by georg on 30.05.2017.
 */
public class ProjectTask extends Model {
    @Id
    @Column(name = "projecttask_id")
    private Long id;

    @ManyToOne
    private Project project;

    @ManyToOne
    private Task task;

    @Transient
    private String tmpproject;
    @Transient
    private String tmptask;

    public static Finder<Long, ProjectTask> find = new Finder<Long, ProjectTask>(ProjectTask.class);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getTmpproject() {
        return tmpproject;
    }

    public void setTmpproject(String tmpproject) {
        this.tmpproject = tmpproject;
    }

    public String getTmptask() {
        return tmptask;
    }

    public void setTmptask(String tmptask) {
        this.tmptask = tmptask;
    }

}
