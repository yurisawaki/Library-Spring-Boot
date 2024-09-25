package sawaki.yuri.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sawaki.yuri.library.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
