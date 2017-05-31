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
}
