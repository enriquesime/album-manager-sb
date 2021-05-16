package com.etech.albummanagerappsb;

import com.etech.albummanagerappsb.domain.Album;
import com.etech.albummanagerappsb.repo.AlbumRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbInitializer implements CommandLineRunner {
    private AlbumRepository albumRepository;


    public DbInitializer(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public void run(String... args) {

            this.albumRepository.findAll().clear();
            Album album = new Album();
            album.setAlbumId(1);
            album.setTitle("accusamus beatae ad facilis cum similique qui sunt");
            album.setUrl("https://via.placeholder.com/600/92c952");
            album.setThumbnailUrl("https://via.placeholder.com/150/92c952");

            Album album2 = new Album();
            album2.setAlbumId(2);
            album2.setTitle("reprehenderit est deserunt velit ipsam");
            album2.setUrl("https://via.placeholder.com/600/771796");
            album2.setThumbnailUrl("https://via.placeholder.com/150/771796");

            Album album3 = new Album();
            album3.setAlbumId(3);
            album3.setTitle("officia porro iure quia iusto qui ipsa ut modi");
            album3.setUrl("https://via.placeholder.com/600/24f355");
            album3.setThumbnailUrl("https://via.placeholder.com/150/24f355");

            Album album4 = new Album();
            album4.setAlbumId(4);
            album4.setTitle("culpa odio esse rerum omnis laboriosam voluptate repudiandae");
            album4.setUrl("https://via.placeholder.com/600/d32776");
            album4.setThumbnailUrl("https://via.placeholder.com/150/d32776");

            Album album5 = new Album();
            album5.setAlbumId(5);
            album5.setTitle("natus nisi omnis corporis facere molestiae rerum in");
            album5.setUrl("https://via.placeholder.com/600/f66b97");
            album5.setThumbnailUrl("https://via.placeholder.com/150/f66b97");

            Album album6 = new Album();
            album6.setAlbumId(6);
            album6.setTitle("accusamus ea aliquid et amet sequi nemo");
            album6.setUrl("https://via.placeholder.com/600/56a8c2");
            album6.setThumbnailUrl("https://via.placeholder.com/150/56a8c2");


            albumRepository.save(album);
            albumRepository.save(album2);
            albumRepository.save(album3);
            albumRepository.save(album4);
            albumRepository.save(album5);
            albumRepository.save(album6);

            System.out.println("****************************************************");
            System.out.println("************Data added***************************");
            System.out.println("****************************************************");
    }
}
