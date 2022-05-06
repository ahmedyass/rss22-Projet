package fr.univrouen.rss22Project.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.univrouen.rss22Project.Models.Article;
import fr.univrouen.rss22Project.Repositories.ArticleRepository;

public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Override
	public List<Article> findAll() {
		return articleRepository.findAll();
	}
	
	@Override
	public Optional<Article> findById(Long id) {
		
		Optional<Article> articleFound = articleRepository.findById(id);
        
		return articleFound;
	}
	
	@Override
	public List<Article> findArticles(String title) {
		return articleRepository.findByTitleContaining(title);
	}
	
	@Override
	public Article save(Article article) {
		Article _article = articleRepository.save(article);
		return _article;
	}
	
	@Override
	public void deleteById(Long id) {
		articleRepository.deleteById(id);
	}

}
