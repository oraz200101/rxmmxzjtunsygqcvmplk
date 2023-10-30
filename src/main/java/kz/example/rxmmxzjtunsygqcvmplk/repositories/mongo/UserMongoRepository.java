package kz.example.rxmmxzjtunsygqcvmplk.repositories.mongo;

import kz.example.rxmmxzjtunsygqcvmplk.model.entities.UserMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserMongoRepository extends MongoRepository<UserMongo, String> {
    @Query("{$or:[{'firstPhoneNumber':?0}, {'secondPhoneNumber': ?0}]}")
    Optional<UserMongo> findByPhoneNumber(String phoneNumber);


}
