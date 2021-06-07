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
           port(Port);

        staticFileLocation("/public");
        Hero.setUpNewHero();
        Hero.setUpNewHero1();
        Hero.setUpNewHero2();
//        Squad.setUpNewSquad();

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/form", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> hero = Hero.getAllInstances();
            model.put("hero", hero);
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());

        post("/new/hero",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            int age = Integer.parseInt(req.queryParams("age"));
            String power = req.queryParams("power");
            String weakness = req.queryParams("weakness");
            int id = Integer.parseInt(req.queryParams("id"));
            Hero newHero = new Hero(name,age,power,weakness,id);
            req.session().attribute("item",name);
            model.put("item", req.session().attribute("item"));
            model.put("newHero",newHero);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

//        get("/new/hero", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            ArrayList<Hero> hero = Hero.getAllInstances();
//            String name = request.queryParams("name");
//            int age = Integer.parseInt(request.queryParams("age"));
//            String power = request.queryParams("power");
//            String weakness = request.queryParams("weakness");
//            int id = Integer.parseInt(request.queryParams("id"));
//            Hero newHero = new Hero(name,age,power,weakness,id);
//            model.put("newHero", newHero);
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());

        get("/squad", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
