package fr.univrouen.rss22Projet.rss22Projet.Controllers;

import fr.univrouen.rss22Projet.rss22Projet.Models.Article;
import fr.univrouen.rss22Projet.rss22Projet.Services.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ArticlesListXmlController {

    @Autowired
    private ArticleServiceImpl articleService;

    @GetMapping(value = "/rss22/resume/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody
    List<Article> getArticlesListXML(Model model) {
        List<Article> articles = articleService.findAll();
        return articles;
    }

    @GetMapping(value = "/rss22/xml/{guid}", produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody
    Article getArticleXML(@PathVariable("guid") Long guid, Model model) {
        Article article = articleService.findById(guid);
        return article;
    }
}
