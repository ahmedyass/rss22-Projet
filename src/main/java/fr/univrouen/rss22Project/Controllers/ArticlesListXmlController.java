package fr.univrouen.rss22Project.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.univrouen.rss22Project.Models.Article;
import fr.univrouen.rss22Project.Services.ArticleServiceImpl;

@RestController
@RequestMapping(value = "/rss22")
public class ArticlesListXmlController {
	
	private ArticleServiceImpl articleService;
	
	@GetMapping(value = "/resume/xml", produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody List<Article> getArticlesListXML(Model model) {
		List<Article> articles = articleService.findAll();
        return articles;
	}
	
	@GetMapping(value="/rss22/html/{guid}", produces = MediaType.APPLICATION_XML_VALUE)
	public Optional<Article> getArticleXML(@PathVariable("guid") Long guid, Model model) {
	    Optional<Article> article = articleService.findById(guid);
	    return article;
	}
}
