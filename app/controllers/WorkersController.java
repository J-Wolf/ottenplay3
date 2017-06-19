package controllers;

import models.Worker;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by georg on 21.05.2017.
 */
public class WorkersController extends Controller {
    public Result index() {
        List<Worker> workerList = Worker.find.all();
        return ok(views.html.workers.render(workerList));
    }

    public Result show(Long id){
        Worker worker = Worker.find.byId(id);
        return ok(views.html.workerDetail.render(worker));
    }

    @Inject
    public FormFactory formFactory;

    public Result create(){
        Form<Worker> workerForm = formFactory.form(Worker.class);
        Worker worker = workerForm.bindFromRequest().get();
        worker.save();
        return  redirect(routes.WorkersController.index());
    }

    public Result delete(Long id){
        Worker worker = Worker.find.byId(id);
        worker.delete();
        return redirect(routes.WorkersController.index());
    }

    public Result update(Long id){
        Worker worker = Worker.find.byId(id);
        Worker new_worker;
        Form<Worker> workerForm = formFactory.form(Worker.class);
        new_worker = workerForm.bindFromRequest().get();
        if(new_worker.getPrename()!=null){
            worker.setPrename(new_worker.getPrename());
        }
        if(new_worker.getLastname()!=null){
            worker.setLastname(new_worker.getLastname());
        }
        worker.save();
        return redirect(routes.WorkersController.index());
    }

}
