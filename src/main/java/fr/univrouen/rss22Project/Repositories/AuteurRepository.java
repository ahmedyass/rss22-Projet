package fr.univrouen.rss22Project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.univrouen.rss22Project.Models.Auteur;

@Repository
public interface AuteurRepository extends JpaRepository<Auteur, Long>  {
	public Auteur findAuteurByEmail(String email);

}
