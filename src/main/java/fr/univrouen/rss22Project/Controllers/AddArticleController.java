package fr.univrouen.rss22Project.Controllers;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.xml.sax.SAXException;

import fr.univrouen.rss22Project.Services.FeedServiceImpl;

@Controller
public class AddArticleController {

	private FeedServiceImpl feedService;
	
	@PostMapping(value = "/rss22/insert", produces = MediaType.APPLICATION_XML_VALUE)
	public String createarticle(@RequestBody String feed) throws JAXBException, SAXException, IOException {
		if( feedService.validateXMLSchema(feed) == true) {
			feedService.save(feedService.convertXML(feed));
			return "redirect:/rss22/resume/html";
		}
		return "redirect:/rss22/resume/html";
	}
}
