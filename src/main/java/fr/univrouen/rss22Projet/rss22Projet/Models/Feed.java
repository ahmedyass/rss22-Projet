package fr.univrouen.rss22Projet.rss22Projet.Models;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Set;

@XmlRootElement(name = "feed")
@XmlAccessorType(XmlAccessType.NONE)
@Entity(name = "Feed")
@Table(name = "feed")
public class Feed implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @XmlElement
    @Column
    private String title;

    @XmlElement
    @Column
    private String pubDate;

    @XmlElement
    @Column
    private String copyright;

    @XmlElement
    @Column
    private String link;

    @XmlElementWrapper(name = "items")
    @XmlElement(name = "item")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Article> items;

    public Feed() {
    }

    public Feed(long id, String title, String pubDate, String copyright, String link, Set<Article> items) {
        this.id = id;
        this.title = title;
        this.pubDate = pubDate;
        this.copyright = copyright;
        this.link = link;
        this.items = items;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Set<Article> getItems() {
        return items;
    }

    public void setItems(Set<Article> items) {
        this.items = items;
    }
}
