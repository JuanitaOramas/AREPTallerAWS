package org.example;



import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static spark.Spark.*;

public class SparkWebServer {

    static int count = 0;
    static String[] urls = new String[] {"http://3.90.62.177:9000/mensajitos", "http://100.24.240.33:9000/mensajitos", "http://100.26.175.18:9000/mensajitos"};
    public static void main(String... args) {
        staticFileLocation("/public");
        port(9000);
        post("mensajitos", (req, resp)-> {
            if (count > 2){count = 0;}
            count +=1;
            String consultarURL = urls[count];
            return HTTPConnection.connection(consultarURL, req.body()) + consultarURL;
        });



    }
}