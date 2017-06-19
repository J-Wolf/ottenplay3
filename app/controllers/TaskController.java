package controllers;

import models.Otte;
import models.Task;
import models.Project;
import models.Worker;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by georg on 26.05.2017.
 */
public class TaskController extends Controller{

    public Result index() {
        List<Task> taskList = Task.find.all();
        return ok(views.html.tasks.render(taskList));
    }

    @Inject
    public FormFactory formFactory;

    public Result create(){
        Form<Task> taskForm = formFactory.form(Task.class);
        Task task = taskForm.bindFromRequest().get();
        task.setWorker(Worker.find.byId(Long.parseLong(task.getTmpWorker())));
        task.setOtte(Otte.find.byId(Long.parseLong(task.getTmpOtte())));
        task.save();
        return  redirect(routes.TaskController.index());
    }

    public Result delete(Long id){
        Task task = Task.find.byId(id);
        task.delete();
        return redirect(routes.TaskController.index());
    }

    public Result update(Long id){
        Task task = Task.find.byId(id);
        Task new_task;
        Form<Task> taskForm = formFactory.form(Task.class);
        new_task = taskForm.bindFromRequest().get();
        if(new_task.getName()!=null){
            task.setName(new_task.getName());
        }
        if(new_task.getWorker()!=null){
            task.setWorker(new_task.getWorker());
        }
        if(new_task.getOtte()!=null){
            task.setOtte(new_task.getOtte());
        }
        if(new_task.getDuration()>0){
            task.setOtte(new_task.getOtte());
        }
        task.save();
        return redirect(routes.OttenController.index());
    }
}
