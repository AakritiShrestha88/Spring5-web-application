package springframework.Spring5webApp.repositories;



import org.springframework.data.repository.CrudRepository;
import springframework.Spring5webApp.domain.Book;

public interface BookRepository extends CrudRepository<Book,Long> {
}
