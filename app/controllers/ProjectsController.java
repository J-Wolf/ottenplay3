package controllers;

import models.Customer;
import models.Project;
import models.Task;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by georg on 21.05.2017.
 */
public class ProjectsController extends Controller{

    public Result index() {
        List<Project> projectList = Project.find.all();
        return ok(views.html.projects.render(projectList));
    }

    @Inject
    public FormFactory formFactory;

    public Result show(Long id){
        Project project = Project.find.byId(id);
        List tasks = Task.find.all();
        return ok(views.html.projectDetail.render(project, tasks));
    }

    public Result create(){
        Form<Project> projectForm = formFactory.form(Project.class);
        Project project = projectForm.bindFromRequest().get();
        project.setCustomer(Customer.find.byId(Long.parseLong(project.getTmpCustomer())));
        project.save();
        return  redirect(routes.ProjectsController.index());
    }
    public Result delete(Long id){
        Project project = Project.find.byId(id);
        project.delete();
        return redirect(routes.ProjectsController.index());
    }

}
