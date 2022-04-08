package edu.eci.arep;

import static spark.Spark.*;
import com.google.gson.Gson;
import edu.eci.arep.posts.models.Posts;
import edu.eci.arep.posts.persistence.PostsPersistence;
import edu.eci.arep.posts.persistence.impl.PostsPersistenceImpl;

public class SparkWebApp {

    private static PostsPersistence postsPersistence = new PostsPersistenceImpl();

    public static void main(String[] args) {
        staticFiles.location("/public");
        port(getPort());
        get("/stream",(req, res)->{
            res.type("application/json");
            return new Gson().toJsonTree(postsPersistence.getPosts());
        });
        post("/stream", (request, response) -> {
            response.type("application/json");
            Posts text = new Gson().fromJson(request.body(), Posts.class);
            postsPersistence.addPost(text);
            return new Gson()
              .toJson(true);
        });
    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
        //returns default port if heroku-port isn't set (i.e. on localhost)
    }

}
