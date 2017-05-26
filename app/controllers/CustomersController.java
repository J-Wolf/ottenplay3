package controllers;

import models.Customer;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by georg on 21.05.2017.
 */
public class CustomersController extends Controller{
    public Result index() {
        List<Customer> customerList = Customer.find.all();
        return ok(views.html.customers.render(customerList));
    }
    @Inject
    public FormFactory formFactory;

    public Result create(){
        Form<Customer> customerForm = formFactory.form(Customer.class);
        Customer customer = customerForm.bindFromRequest().get();
        customer.save();
        return  redirect(routes.CustomersController.index());
    }
}
