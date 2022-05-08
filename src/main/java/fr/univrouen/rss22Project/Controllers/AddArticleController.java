package fr.univrouen.rss22Project.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.xml.sax.SAXException;

import fr.univrouen.rss22Project.Models.Article;
import fr.univrouen.rss22Project.Services.ArticleServiceImpl;
import fr.univrouen.rss22Project.Services.FeedServiceImpl;

@Controller
public class AddArticleController {

	private FeedServiceImpl feedService;
	private ArticleServiceImpl articleService;
	
	@PostMapping(value = "/rss22/insert", produces = MediaType.APPLICATION_XML_VALUE)
	public String createarticle(@RequestBody String feed) throws JAXBException, SAXException, IOException {
		if( feedService.validateXMLSchema(feed) == true) {
			feedService.save(feedService.convertXML(feed));
			List<Article> articles = new ArrayList<>(feedService.convertXML(feed).getItems());
			articleService.saveMultiple(articles);
			return "redirect:/rss22/resume/html";
		}
		return "redirect:/rss22/resume/html";
	}
}
