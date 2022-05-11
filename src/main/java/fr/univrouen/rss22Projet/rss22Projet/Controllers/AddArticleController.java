package fr.univrouen.rss22Projet.rss22Projet.Controllers;

import fr.univrouen.rss22Projet.rss22Projet.Models.Article;
import fr.univrouen.rss22Projet.rss22Projet.Models.Auteur;
import fr.univrouen.rss22Projet.rss22Projet.Models.Feed;
import fr.univrouen.rss22Projet.rss22Projet.Models.FeedInput;
import fr.univrouen.rss22Projet.rss22Projet.Services.ArticleServiceImpl;
import fr.univrouen.rss22Projet.rss22Projet.Services.AuteurServiceImpl;
import fr.univrouen.rss22Projet.rss22Projet.Services.FeedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class AddArticleController {

    @Autowired
    private FeedServiceImpl feedService;

    @Autowired
    private ArticleServiceImpl articleService;

    @Autowired
    private AuteurServiceImpl auteurService;

    @PostMapping(path = "/rss22/insert", produces = MediaType.APPLICATION_XML_VALUE)
    public String addArticle(@ModelAttribute("feed") FeedInput feed) throws JAXBException, SAXException, IOException {
        String feedInput = feed.getFeed();
        if( feedService.validateXMLSchema(feedInput) == true) {
            Feed _feed = feedService.convertXML(feedInput);
            if(_feed == null) {
                return "redirect:/rss22/resume/html?message=Le+feed+est+vide";
            } else {
                feedService.save(_feed);

                List<Article> articles = new ArrayList<>(feedService.convertXML(feedInput).getItems());
                articles.forEach(article -> article.setFeed(_feed));
                articleService.saveMultiple(articles);

                articles.forEach( article -> {
                    Set<Auteur> authors = article.getAutors();
                    authors.forEach( auteur -> {
                        if (auteurService.findAuteur(auteur.getId()) == null) {
                            authors.add(auteur);
                            auteurService.save(auteur);}
                    });
                    article.setAutors(authors);
                    articleService.save(article);
                });
                return "redirect:/rss22/resume/html?message=Les+articles+sont+bien+ajoutés";
            }
        }
        return "redirect:/rss22/resume/html?message=Le+schéma+XML+n'est+pas+valide";
    }
}
