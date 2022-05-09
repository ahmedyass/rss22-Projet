package fr.univrouen.rss22Project.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.univrouen.rss22Project.Models.Article;
import fr.univrouen.rss22Project.Services.ArticleServiceImpl;

@Controller
@RequestMapping(value = "/rss22")
public class ArticlesListHtmlController {
	
	private ArticleServiceImpl articleService;
	
	@GetMapping(value = "/resume/html", produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody String getArticlesList(Model model) {
		model.addAttribute("items", articleService.findAll());
        return "ListeArticle";
	}
	
	@GetMapping(value="/html/{guid}", produces = MediaType.APPLICATION_XML_VALUE)
	public String getItemHtml(@PathVariable("guid") long guid, Model model) {
	    Optional<Article> article = articleService.findById(guid);
	    model.addAttribute("item", article);
	    return "ArticleDetails";
	}
	
	@RequestMapping(value = "/search")
	public String searchArticles(Article item, Model model, @RequestParam(name = "title") String title) {
		if(title!=null) {
			List<Article> list = articleService.findArticles(title);
			model.addAttribute("items", list);
		} else {
			List<Article> list = articleService.findAll();
			model.addAttribute("items", list);
		}
		return "ListeArticle";
	}
}
