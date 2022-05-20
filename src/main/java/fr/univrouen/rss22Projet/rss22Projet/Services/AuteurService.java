package fr.univrouen.rss22Projet.rss22Projet.Services;

import fr.univrouen.rss22Projet.rss22Projet.Models.Article;
import fr.univrouen.rss22Projet.rss22Projet.Models.Auteur;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.util.List;

@Service
public interface AuteurService {

    Auteur findAuteur(long id);
    void save(Auteur auteur);
    void saveMultiple(List<Auteur> auteurs);
}
