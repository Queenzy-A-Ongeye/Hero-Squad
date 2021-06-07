import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    private static int Port;

    public static void main(String[] args) {
        ProcessBuilder process = new ProcessBuilder();
            Integer port = null;
           if (process.environment().get("PORT") != null){
                Port = Integer.parseInt(process.environment().get("PORT"));
            }else{
               port = 4567;
            }
           port(port);

        staticFileLocation("/public");
        Hero.setUpNewHero();
        Hero.setUpNewHero1();
//        Squad.setUpNewSquad();

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hero", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
