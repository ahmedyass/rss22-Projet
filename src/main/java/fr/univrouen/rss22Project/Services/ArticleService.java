package fr.univrouen.rss22Project.Services;

import java.util.List;
import java.util.Optional;

import fr.univrouen.rss22Project.Models.Article;


public interface ArticleService {
	
	public List<Article> findAll();
	public Optional<Article> findById(Long id);
	public List<Article> findArticles(String title);
	public void save(Article article);
	public void saveMultiple(List<Article> articles);
	public void deleteById(Long id);

}
