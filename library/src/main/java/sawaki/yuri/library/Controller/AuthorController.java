package sawaki.yuri.library.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sawaki.yuri.library.entities.Author;
import sawaki.yuri.library.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping(value = "/author")
public class AuthorController {
    @Autowired
    private AuthorService service;

    @PostMapping
    public ResponseEntity<Author> create(@RequestBody Author obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public  ResponseEntity<Author> getId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getId(id));
    }

    @GetMapping
    public ResponseEntity<List<Author>> getId(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Author> update(@PathVariable Long id, @RequestBody Author obj){
        obj.setId(id);
        return ResponseEntity.ok().body(service.update(obj));
    }



}
