package fr.univrouen.rss22Project.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.univrouen.rss22Project.Models.Auteur;
import fr.univrouen.rss22Project.Repositories.AuteurRepository;

public class AuteurServiceImpl implements AuteurService {
	
	@Autowired
	private AuteurRepository auteurRepository;
	
	@Override
	public void saveMultiple(List<Auteur> auteurs) {
		this.auteurRepository.saveAll(auteurs);
	}

}
