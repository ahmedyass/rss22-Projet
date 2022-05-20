package fr.univrouen.rss22Projet.rss22Projet.Models;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name = "Article")
@Table(name = "article")
public class Article implements Serializable {
    @Id
    @Column
    @XmlAttribute
    private long guid;

    @XmlElement
    @Column
    private String title;

    @XmlElement
    @Column
    private String published;

    @XmlElement
    @Column
    private String category;

    @XmlElement
    @Column(columnDefinition = "text")
    private String content;

    @XmlElementWrapper(name = "authors")
    @XmlElement(name = "author")
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Auteur> autors;

    @ManyToOne
    @JoinColumn(name = "feed_id")
    Feed feed;

    public Article() {
    }

    public Article(long guid, String title, String published, String category, String content, List<Auteur> autors, Feed feed) {
        this.guid = guid;
        this.title = title;
        this.published = published;
        this.category = category;
        this.content = content;
        this.autors = autors;
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

    public List<Auteur> getAutors() {
        return autors;
    }

    public void setAutors(List<Auteur> autors) {
        this.autors = autors;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }
}
