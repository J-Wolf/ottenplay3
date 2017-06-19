package controllers;

import com.google.inject.Inject;
import models.*;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;


import java.util.List;

/**
 * Created by martinschipflinger on 09.05.17.
 */
public class FormController extends Controller {
    @Inject
    public FormFactory formFactory;

    public Result loginUser(){
        Form<User> loginForm = formFactory.form(User.class);
        return ok(views.html.login.render(loginForm));
    }

    public Result addProject(){
        List<Customer> customerList = Customer.find.all();
        Form<Project> projectForm = formFactory.form(Project.class);
        return ok(views.html.addProject.render(projectForm, customerList));
    }

    public Result addProjectTask(){
        List<Task> taskList = Task.find.all();
        List<Project> projectList = Project.find.all();
        Form<ProjectTask> projectTaskForm = formFactory.form(ProjectTask.class);
        return ok(views.html.addProjectTask.render(projectTaskForm, projectList, taskList));
    }

    public Result addWorker(){
        Form<Worker> workerForm = formFactory.form(Worker.class);
        return ok(views.html.addWorker.render(workerForm));
    }

    public Result addCustomer(){
        Form<Customer> customerForm = formFactory.form(Customer.class);
        return ok(views.html.addCustomer.render(customerForm));
    }

    public Result addOtte(){
        Form<Otte> otteForm = formFactory.form(Otte.class);
        return ok(views.html.addOtte.render(otteForm));
    }

    public Result updateOtte(Long id){
        Form<Otte> otteForm = formFactory.form(Otte.class);
        return ok(views.html.updateOtte.render(otteForm, id));
    }

    public Result updateCustomer(Long id){
        Form<Customer> customerForm = formFactory.form(Customer.class);
        return ok(views.html.updateCustomer.render(customerForm, id));
    }

    public Result updateProject(Long id){
        Form<Project> projectForm = formFactory.form(Project.class);
        return ok(views.html.updateProject.render(projectForm, id));
    }

    public Result updateWorker(Long id){
        Form<Worker> workerForm = formFactory.form(Worker.class);
        return ok(views.html.updateWorker.render(workerForm, id));
    }


    public Result addTask(){
        List<Worker> workerList = Worker.find.all();
        List<Otte> otteList = Otte.find.all();
        Form<Task> taskForm = formFactory.form(Task.class);
        return ok(views.html.addTask.render(taskForm, workerList, otteList));
    }


}
