package app;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhrasesRepository extends CrudRepository<Phrase, Integer> {
}
