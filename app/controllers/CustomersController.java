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

    public Result delete(Long id){
        Customer customer = Customer.find.byId(id);
        customer.delete();
        return redirect(routes.CustomersController.index());
    }
    public Result update(Long id){
        Customer customer = Customer.find.byId(id);
        Customer new_customer;
        Form<Customer> customerForm = formFactory.form(Customer.class);
        new_customer = customerForm.bindFromRequest().get();
        if(new_customer.getPrename()!=null){
            customer.setPrename(new_customer.getPrename());
        }
        if(new_customer.getLastname()!=null){
            customer.setLastname(new_customer.getLastname());
        }
        if(new_customer.getAddress()!=null){
            customer.setAddress(new_customer.getAddress());
        }
        if(new_customer.getEmail()!=null){
            customer.setEmail(new_customer.getEmail());
        }
        customer.save();
        return redirect(routes.OttenController.index());
    }
}
