package fr.univrouen.rss22Project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.univrouen.rss22Project.Models.Feed;

public interface FeedRepository extends JpaRepository<Feed, Long> {

}
