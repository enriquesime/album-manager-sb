package com.etech.albummanagerappsb.service;

import com.etech.albummanagerappsb.domain.Album;
import com.etech.albummanagerappsb.repo.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository=albumRepository;
    }

    public  void createAlbum(Album album){
      this.albumRepository.save(album);
    }

    public List<Album> getAlbums(){

     return this.albumRepository.findAll();
    }

    public Optional<Album> getAlbumById(Integer albumId){

        return this.albumRepository.findById(albumId);
    }

    public void deleteAlbumById(Integer albumId){

        this.albumRepository.deleteById(albumId);
    }

    public Album updateAlbum(Album album){
        this.albumRepository.save(album);
        return album;
    }
}
