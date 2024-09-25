package sawaki.yuri.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sawaki.yuri.library.entities.Book;
import sawaki.yuri.library.repository.BookRepository;
import sawaki.yuri.library.service.exception.EntityNotFound;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public Book create(Book obj){
        return repository.save(obj);

    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Book getId(Long id){
        Optional<Book> obj = repository.findById(id);
        if (obj.isEmpty()){
            throw new EntityNotFound("Livro de id: "+id+" nao encontrado" );
        }
        return obj.get();
    }

    public List<Book> getAll(){
        return repository.findAll();
    }

    public Book update(Book obj){
        Optional<Book> newObj = repository.findById(obj.getId());
        if (newObj.isEmpty()){
            throw new EntityNotFound("Livro de id: "+obj.getId()+" nao encontrado" );
        }
        updateBook(newObj, obj);
        return repository.save(newObj.get());
    }

    private  void updateBook(Optional<Book> newObj, Book obj){
        newObj.get().setName(obj.getName());

    }

}
