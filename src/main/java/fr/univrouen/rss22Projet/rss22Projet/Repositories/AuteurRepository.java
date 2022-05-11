package fr.univrouen.rss22Projet.rss22Projet.Repositories;

import fr.univrouen.rss22Projet.rss22Projet.Models.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuteurRepository extends JpaRepository<Auteur, Long> {
}
