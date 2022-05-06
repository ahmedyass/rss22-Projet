package fr.univrouen.rss22Project.Controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.univrouen.rss22Project.Services.ArticleServiceImpl;

@Controller
public class DeleteArticleController {
	
	private ArticleServiceImpl articleService;
	
	
	@DeleteMapping(value="/rss22/delete/{guid}", produces = MediaType.APPLICATION_XML_VALUE)
	public String deleteArticle(@PathVariable("guid") Long guid, Model model) {
		articleService.deleteById(guid);
	    return "redirect:/rss22/resume/html";
	}

}
