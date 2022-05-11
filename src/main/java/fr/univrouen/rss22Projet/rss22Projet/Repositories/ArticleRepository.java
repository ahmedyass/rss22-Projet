package fr.univrouen.rss22Projet.rss22Projet.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.univrouen.rss22Projet.rss22Projet.Models.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByTitleContaining(String title);
}
