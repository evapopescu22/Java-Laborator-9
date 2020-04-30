package entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "ARTISTS")
@NamedNativeQuery(name = "findByName", query = "SELECT a.id, a.name, a.country " + "FROM Artists a "
		+ "WHERE a.name = ?", resultClass = Artist.class)
public class Artist implements Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "MusicAlbumsPU")
	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "country")
	private String country;

	@Column(name = "name")
	private String name;

	public Artist() {
	}

	public Artist(String name) {
		this.name = name;

	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + this.getName() + ", country=" + this.getCountry() + "]";
	}
}