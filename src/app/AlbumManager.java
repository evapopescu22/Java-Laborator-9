package app;

import entity.Album;
import entity.Artist;
import repo.AlbumRepository;
import repo.ArtistRepository;

public class AlbumManager {

	public static void main(String[] args) {

		ArtistRepository.findById(3);
		ArtistRepository.findByName("The Clash");
		AlbumRepository.findById(9);
		AlbumRepository.findByName("Loaded");
		AlbumRepository.findByArtist("Bob Dylan");
        
		ArtistRepository artrep = new ArtistRepository();
		Artist artist = new Artist();
		artist.setId(Integer.BYTES);
		artist.setName("John Lennon");
		artist.setCountry("England");
		artrep.create(artist);
		

		AlbumRepository albrep = new AlbumRepository();
		Album album = new Album();
		album.setId(Integer.BYTES);
		album.setName("Plastic Ono Band");
		album.setArtistId(26);
		album.setReleaseYear(1970);
		albrep.create(album); 

	}

}
