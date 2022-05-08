package fr.univrouen.rss22Project.Models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.NONE)
@Entity(name = "Article")
@Table(name = "article")
public class Article {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	@XmlAttribute
	private Long guid;
	
	@XmlElement
	private String title;
	
	@XmlElement
	private String published;
	
	@XmlElement
	private String category;
	
	@XmlElement
	private String image;
	
	@XmlElement
	private String content;
	
	@XmlElementWrapper(name = "authors")
    @XmlElement(name = "author")
	@OneToMany(cascade = CascadeType.ALL)
    private Set<Auteur> autors;
	
	@ManyToOne
    @JoinColumn(name = "feed_id")
    Feed feed;
	
	public Feed getFeed() {
		return feed;
	}
	
	public void setFeed(Feed feed) {
		this.feed = feed;
	}
	
	public long getGuid() {
		return guid;
	}
	
	public void setGuid(long guid) {
		this.guid = guid;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public Set<Auteur> getAutors() {
		return autors;
	}
	
	public void setAutors(Set<Auteur> autors) {
		this.autors = autors;
	}
	
	public Article() {}
	
	public Article(Long guid, String title, String published, String category, String content, Set<Auteur> autors) {
		super();
		this.guid = guid;
		this.title = title;
		this.published = published;
		this.category = category;
		this.content = content;
		this.autors = autors;
	}
	
	public String getPublished() {
		return published;
	}
	
	public void setPublished(String published) {
		this.published = published;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return ("Article : " + title + "\n(" + guid + ") Le = " + published );
	}
}

