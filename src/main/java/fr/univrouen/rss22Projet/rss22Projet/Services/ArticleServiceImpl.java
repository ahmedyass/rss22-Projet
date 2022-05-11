package fr.univrouen.rss22Projet.rss22Projet.Services;

import fr.univrouen.rss22Projet.rss22Projet.Models.Article;
import fr.univrouen.rss22Projet.rss22Projet.Repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article findById(long guid) {
        Optional<Article> optional = articleRepository.findById(guid);
        Article article = null;
        if (optional.isPresent()) {
            article = optional.get();
        } else {
            throw new RuntimeException(" Article not found for id :: " + guid);
        }
        return article;
    }

    @Override
    public List<Article> findArticles(String title) {
        return articleRepository.findByTitleContaining(title);
    }

    @Override
    public void save(Article article) {
        this.articleRepository.save(article);
    }

    @Override
    public void saveMultiple(List<Article> articles) {
        this.articleRepository.saveAll(articles);
    }

    @Override
    public void deleteById(long guid) {
        this.articleRepository.deleteById(guid);
    }
}
