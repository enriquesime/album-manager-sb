package com.etech.albummanagerappsb.web;



import com.etech.albummanagerappsb.domain.Album;
import com.etech.albummanagerappsb.expceptions.ResourceNotFound;
import com.etech.albummanagerappsb.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class AlbumController {
   @Autowired
   private AlbumService albumService;

    @GetMapping("/albums")
    public List<Album> getAlbums() {
        return this.albumService.getAlbums();
    }


    @GetMapping("/albums/{albumId}")
    public Album getAlbumById(@PathVariable Integer albumId) throws ResourceNotFound {
        Optional<Album> album = this.albumService.getAlbumById(albumId);
        if(!album.isPresent()){
           throw new ResourceNotFound("Resource not found");
        };

        return album.get();
    }

    @PostMapping("/albums")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAlbum(@RequestBody Album album) {

        // also just in case the pass an id in JSON ... set id to 0
        // this is force a save of new item ... instead of update
        album.setId(null);
        this.albumService.createAlbum(album);
    }

    // add mapping for PUT /albums - update existing album

    @PutMapping("/albums")
    @ResponseStatus(HttpStatus.CREATED)
    public Album updateAlbum(@RequestBody Album album) {

        this.albumService.updateAlbum(album);

        return album;
    }

    //add mapping for DELETE /albums/{albumId} - delete existing album

    @DeleteMapping("/albums/{albumId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlbum(@PathVariable Integer albumId) {
        this.albumService.deleteAlbumById(albumId);
    }
}
