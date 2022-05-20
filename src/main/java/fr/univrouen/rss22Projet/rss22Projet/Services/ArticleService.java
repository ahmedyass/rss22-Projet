package fr.univrouen.rss22Projet.rss22Projet.Services;

import fr.univrouen.rss22Projet.rss22Projet.Models.Article;

import javax.xml.bind.JAXBException;
import java.util.List;

public interface ArticleService {
    List<Article> findAll();
    Article findById(long guid);
    List<Article> findArticles(String title);
    void save(Article article);
    void saveMultiple(List<Article> articles);
    void deleteById(long guid);
    List<Article> convertXML(String xml) throws JAXBException;
}
