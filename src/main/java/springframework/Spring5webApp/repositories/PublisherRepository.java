package springframework.Spring5webApp.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.Spring5webApp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
