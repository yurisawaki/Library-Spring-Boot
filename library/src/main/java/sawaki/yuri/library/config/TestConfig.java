package sawaki.yuri.library.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import sawaki.yuri.library.entities.Author;
import sawaki.yuri.library.entities.Book;
import sawaki.yuri.library.repository.AuthorRepository;
import sawaki.yuri.library.repository.BookRepository;

import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {
        Author a1 = new Author(null, "Tolkien");
        Author a2 = new Author(null, "CS Lewis");

        authorRepository.saveAll(Arrays.asList(a1,a2));

        Book b1 = new Book(null, "Senhor dos Aneis",a1);
        Book b2 = new Book(null, "As Cronicas de Narnia",a2);

        bookRepository.saveAll(Arrays.asList(b1,b2));
    }


}
