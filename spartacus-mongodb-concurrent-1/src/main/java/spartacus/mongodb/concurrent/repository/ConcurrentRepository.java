package spartacus.mongodb.concurrent.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConcurrentRepository extends MongoRepository<ConcurrentItem, String> {
}