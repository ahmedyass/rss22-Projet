package fr.univrouen.rss22Project.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.univrouen.rss22Project.Models.Auteur;
import fr.univrouen.rss22Project.Repositories.AuteurRepository;

public class AuteurServiceImpl implements AuteurService {
	
	@Autowired
	private AuteurRepository auteurRepository;
	
	@Override
	public void saveMultiple(List<Auteur> auteurs) {
		List<Auteur> authors = new ArrayList<>();
		auteurs.forEach(
				auteur -> {
					if(this.auteurRepository.findAuteurByEmail(auteur.getEmail()) == null) {
						authors.add(auteur);
					}
				});
		this.auteurRepository.saveAll(authors);
	}

}
