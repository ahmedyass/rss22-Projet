package fr.univrouen.rss22Project.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name = "Auteur")
@Table(name = "auteur")
public class Auteur {
	
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
    
	@ManyToOne
    @JoinColumn(name = "article_id")
    Article item;
	
	public Auteur() {
		
	}
	
	public Auteur(long id, String name, String email, String uri) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.uri = uri;
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
}
