package fr.univrouen.rss22Projet.rss22Projet.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/help")
    public String help() {
        return "help";
    }
}
