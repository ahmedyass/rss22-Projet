package fr.univrouen.rss22Projet.rss22Projet.Services;

import fr.univrouen.rss22Projet.rss22Projet.Models.Article;
import fr.univrouen.rss22Projet.rss22Projet.Models.Auteur;
import fr.univrouen.rss22Projet.rss22Projet.Models.Feed;
import fr.univrouen.rss22Projet.rss22Projet.Repositories.AuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuteurServiceImpl implements AuteurService {



    @Autowired
    AuteurRepository auteurRepository;

    @Override
    public Auteur findAuteur(long id) {
        Optional<Auteur> optional = auteurRepository.findById(id);
        Auteur auteur = null;
        if (optional.isPresent()) {
            auteur = optional.get();
            return auteur;
        } else {
            return null;
        }
    }

    @Override
    public void save(Auteur auteur) {
        this.auteurRepository.save(auteur);
    }

    @Override
    public void saveMultiple(List<Auteur> auteurs) {
        this.auteurRepository.saveAll(auteurs);
    }
}
