package entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "ALBUMS")
@NamedNativeQueries({
		@NamedNativeQuery(name = "findByName1", query = "SELECT *"
				+ "FROM Albums a" + " WHERE a.name= ?", resultClass = Album.class),
		@NamedNativeQuery(name = "findByArtist", query = "SELECT a.id, a.name, a.artist_id, a.release_year FROM Albums a JOIN Artists b ON a.artist_id=b.id WHERE b.name= ?", resultClass = Album.class), })
public class Album implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "artist_id")
	private int artistId;

	@Column(name = "release_year")
	private int releaseYear;

	public Album() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getReleaseYear() {
		return this.releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", name=" + name + ", artistId=" + artistId + " releaseYear=" + releaseYear + "]";
	}

}