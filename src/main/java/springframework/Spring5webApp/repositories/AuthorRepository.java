package springframework.Spring5webApp.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.Spring5webApp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
