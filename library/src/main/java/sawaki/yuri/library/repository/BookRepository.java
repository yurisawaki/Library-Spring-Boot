package sawaki.yuri.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sawaki.yuri.library.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
