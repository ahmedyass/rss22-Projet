package fr.univrouen.rss22Project.Services;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import fr.univrouen.rss22Project.Models.Feed;
import fr.univrouen.rss22Project.Repositories.FeedRepository;

@Service
public class FeedServiceImpl implements FeedService{
	
	@Autowired
	private FeedRepository feedRepository;
	
	@Override
	public boolean validateXMLSchema(String xml) throws SAXException, IOException{
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
	    }
		return null;
	}

	@Override
	public Feed save(Feed feed) {
		Feed _feed = feedRepository.save(feed);
		return _feed;
	}

}
