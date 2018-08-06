package ml.crop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Url {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true, nullable = false)
	private String url;
	
	@Column(unique = true, nullable = false)
	private String shortenUri;

	public Url() {
		
	}
	
	public Url(String url, String shortenUri) {
		this.url = url;
		this.shortenUri = shortenUri;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getShortenUri() {
		return shortenUri;
	}

	public void setShortenUri(String shortenUri) {
		this.shortenUri = shortenUri;
	}
}
