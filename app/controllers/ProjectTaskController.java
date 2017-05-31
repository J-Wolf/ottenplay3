package controllers;

import models.Project;
import models.ProjectTask;
import models.Task;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

/**
 * Created by georg on 30.05.2017.
 */
public class ProjectTaskController extends Controller {
    @Inject
    public FormFactory formFactory;

    public Result create(){
        Form<ProjectTask> projectTaskForm = formFactory.form(ProjectTask.class);
        ProjectTask projectTask = projectTaskForm.bindFromRequest().get();
        projectTask.setProject(Project.find.byId(Long.parseLong(projectTask.getTmpproject())));
        projectTask.setTask(Task.find.byId(Long.parseLong(projectTask.getTmptask())));
        projectTask.save();
        return redirect(routes.ProjectsController.index());
    }

    public Result delete(Long id){
        ProjectTask projectTask = ProjectTask.find.byId(id);
        projectTask.delete();
        return redirect(routes.ProjectsController.index());
    }

}
