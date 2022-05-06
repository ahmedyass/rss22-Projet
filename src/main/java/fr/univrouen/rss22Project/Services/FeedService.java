package fr.univrouen.rss22Project.Services;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import fr.univrouen.rss22Project.Models.Feed;

@Service
public interface FeedService {
	
	public boolean validateXMLSchema(String xml) throws SAXException, IOException;
	public Feed convertXML(String xml) throws JAXBException;
	public Feed save(Feed feed);

}
