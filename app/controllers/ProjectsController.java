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
        return ok(views.html.projectDetail.render(project));
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

    public Result update(Long id){
        Project project = Project.find.byId(id);
        Project new_project;
        Form<Project> projectForm = formFactory.form(Project.class);
        new_project = projectForm.bindFromRequest().get();
        if(new_project.getName()!=null){
            project.setName(new_project.getName());
        }
        if(new_project.getCustomer()!=null){
            project.setCustomer(new_project.getCustomer());
        }
        if(new_project.getDuration() > 0 ){
            project.setDuration(new_project.getDuration());
        }
        project.save();
        return redirect(routes.ProjectsController.index());
    }


}
