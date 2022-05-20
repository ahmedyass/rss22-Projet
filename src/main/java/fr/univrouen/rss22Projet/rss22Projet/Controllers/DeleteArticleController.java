package fr.univrouen.rss22Projet.rss22Projet.Controllers;

import fr.univrouen.rss22Projet.rss22Projet.Services.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeleteArticleController {

    @Autowired
    private ArticleServiceImpl articleService;

    @RequestMapping(value="/rss22/delete/{guid}", produces = MediaType.APPLICATION_XML_VALUE)
    public String deleteArticle(@PathVariable("guid") Long guid, Model model) {
        articleService.deleteById(guid);
        return "redirect:/rss22/resume/html?message=L'article+"+guid+"+a+bien+ete+supprime";
    }
}
