package fr.univrouen.rss22Projet.rss22Projet.Models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.Set;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name = "Auteur")
@Table(name = "auteur")
public class Auteur implements Serializable {

    @XmlAttribute
    @Id
    @Column
    private long id;

    @XmlElement
    @Column
    private String name;

    @XmlElement
    @Column(unique = true)
    private String email;

    @XmlElement
    @Column
    private String uri;

    @ManyToMany
    @JoinColumn(name = "article_id")
    Set<Article> items;

    public Auteur() {
    }

    public Auteur(long id, String name, String email, String uri, Set<Article> items) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.uri = uri;
        this.items = items;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Set<Article> getItems() {
        return items;
    }

    public void setItems(Set<Article> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Auteur{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", uri='" + uri + '\'' +
                ", items=" + items +
                '}';
    }
}
