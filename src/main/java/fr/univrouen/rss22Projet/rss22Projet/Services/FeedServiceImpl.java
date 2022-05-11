package fr.univrouen.rss22Projet.rss22Projet.Services;

import fr.univrouen.rss22Projet.rss22Projet.Models.Feed;
import fr.univrouen.rss22Projet.rss22Projet.Repositories.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

@Service
public class FeedServiceImpl implements FeedService {

    @Autowired
    FeedRepository feedRepository;

    @Override
    public boolean validateXMLSchema(String xml) throws SAXException, IOException {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File("src/main/resources/static/rss22.xsd"));
            Validator validator = schema.newValidator();
            StringReader reader = new StringReader(xml);
            validator.validate(new StreamSource(reader));
            return true;
        } catch (IOException | SAXException e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Feed convertXML(String xml) throws JAXBException {
        try {
            JAXBContext context = JAXBContext.newInstance(Feed.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Feed feed = (Feed) unmarshaller.unmarshal(new StringReader(xml));
            return feed;
        } catch (JAXBException e) {
            System.out.println("Exception: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void save(Feed feed) {
        this.feedRepository.save(feed);
    }
}
