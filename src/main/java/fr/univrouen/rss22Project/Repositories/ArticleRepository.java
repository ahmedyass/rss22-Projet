package fr.univrouen.rss22Project.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.univrouen.rss22Project.Models.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
	
	@Query(value = "select * from article a where a.title like %:title%", nativeQuery = true)
	List<Article> findByTitleContaining(@Param("title") String title);

}