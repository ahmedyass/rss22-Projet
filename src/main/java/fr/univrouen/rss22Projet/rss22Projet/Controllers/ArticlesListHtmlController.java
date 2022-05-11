package fr.univrouen.rss22Projet.rss22Projet.Controllers;

import fr.univrouen.rss22Projet.rss22Projet.Models.Article;
import fr.univrouen.rss22Projet.rss22Projet.Models.FeedInput;
import fr.univrouen.rss22Projet.rss22Projet.Services.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ArticlesListHtmlController {

    @Autowired
    private ArticleServiceImpl articleService;

    @GetMapping(value = "/rss22/resume/html", produces = MediaType.APPLICATION_XML_VALUE)
    public String getArticlesList(Model model) {
        model.addAttribute("items", articleService.findAll());
        FeedInput input = new FeedInput();
        model.addAttribute("feed", input);
        return "ListeArticles";
    }

    @GetMapping(value = "/rss22/html/{guid}", produces = MediaType.APPLICATION_XML_VALUE)
    public String getItemHtml(@PathVariable("guid") long guid, Model model) {
        model.addAttribute("item", articleService.findById(guid));
        return "ArticleDetails";
    }

    @GetMapping(value = "/rss22/resume/html")
    public String searchArticles(Article item, Model model, @RequestParam(name = "title") String title) {
        List<Article> list = new ArrayList<>();
        if(title!=null) {
            list = articleService.findArticles(title);
        } else {
            list = articleService.findAll();
        }
        model.addAttribute("items", list);
        return "ListeArticles";
    }
}
