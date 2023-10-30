package kz.example.rxmmxzjtunsygqcvmplk.repositories.mongo;

import kz.example.rxmmxzjtunsygqcvmplk.model.entities.UserMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMongoRepository extends MongoRepository<UserMongo, String> {
}
