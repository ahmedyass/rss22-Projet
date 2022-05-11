package fr.univrouen.rss22Projet.rss22Projet.Services;

import fr.univrouen.rss22Projet.rss22Projet.Models.Feed;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public interface FeedService {
    boolean validateXMLSchema(String xml) throws SAXException, IOException;
    Feed convertXML(String xml) throws JAXBException;
    void save(Feed feed);
}
