package controllers;

import models.Otte;
import org.h2.store.fs.FileUtils;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;

import javax.inject.Inject;
import java.io.File;
import java.util.List;

/**
 * Created by georg on 21.05.2017.
 */
public class OttenController extends Controller{


    public Result index() {
        List<Otte> ottenList = Otte.find.all();
        return ok(views.html.otten.render(ottenList));
    }

    @Inject
    public FormFactory formFactory;

    public Result create(){
        Form<Otte> ottenForm = formFactory.form(Otte.class);
        Otte otte = ottenForm.bindFromRequest().get();
        Http.MultipartFormData body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart image = body.getFile("image");

        String fileName = "";
        if (image != null) {
            fileName = image.getFilename();
            File file = (File) image.getFile();

            try {
                FileUtils.move(file.getAbsolutePath(), "public/images/"+fileName);
            } catch (Exception ioe) {
                System.out.println("Problem operating on filesystem");
            }

        }

        otte.setImagepath("images/"+fileName);
        otte.save();
        return  redirect(routes.OttenController.index());
    }
    public Result delete(Long id){
        Otte otte = Otte.find.byId(id);
        otte.delete();
        return redirect(routes.OttenController.index());
    }
}
