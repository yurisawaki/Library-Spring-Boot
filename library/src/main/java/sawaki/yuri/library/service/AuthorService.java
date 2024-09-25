package sawaki.yuri.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sawaki.yuri.library.entities.Author;
import sawaki.yuri.library.repository.AuthorRepository;
import sawaki.yuri.library.service.exception.EntityNotFound;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository repository;

    public Author create(Author obj){
        return repository.save(obj);

    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Author getId(Long id){
        Optional<Author> obj = repository.findById(id);
        if (obj.isEmpty()){
            throw new EntityNotFound("Autor de id: "+id+" nao encontrado" );
        }
        return obj.get();
    }

    public List<Author> getAll(){
        return repository.findAll();
    }

    public Author update(Author obj){
        Optional<Author> newObj = repository.findById(obj.getId());
        if (newObj.isEmpty()){
            throw new EntityNotFound("Autor de id: "+obj.getId()+" nao encontrado" );
        }
        updateAuthor(newObj, obj);
        return repository.save(newObj.get());
    }

    private  void updateAuthor(Optional<Author> newObj, Author obj){
        newObj.get().setName(obj.getName());

    }

}
