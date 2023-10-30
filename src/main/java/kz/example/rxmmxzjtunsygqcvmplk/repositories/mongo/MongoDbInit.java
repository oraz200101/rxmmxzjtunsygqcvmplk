package kz.example.rxmmxzjtunsygqcvmplk.repositories.mongo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import kz.example.rxmmxzjtunsygqcvmplk.model.entities.UserMongo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class MongoDbInit {

    private final UserMongoRepository repository;

    @PostConstruct
    private void loadData(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        UserMongo[] users = {
                new UserMongo("Beimishev Meirzhan", "2003-05-15", "87774567890", "87016543210", currentDateTime),
                new UserMongo("Ziyabek Orazkhan", "2001-12-11", "87751237890", "87770632799", currentDateTime),
                new UserMongo("Ybrakhim Darkhan", "2002-11-10", "87773335555", "87004446666", currentDateTime),
                new UserMongo("Kanat Sultan", "2004-07-25", "87751112222", "87019991111", currentDateTime),
                new UserMongo("Tynys Aday", "2003-09-05", "87028880000", "87024448888", currentDateTime),
                new UserMongo("Abdrashidov Dias", "2002-01-30", "87763337777", "87773332222", currentDateTime),
                new UserMongo("Abu Dias", "2003-04-12", "87024446666", "87471401383", currentDateTime),
                new UserMongo("Yellubay Erasyl", "2001-08-19", "87017773333", "87011117777", currentDateTime),
                new UserMongo("Kuttybekov Ilyas", "2001-12-04", "87772221111", "87005552222", currentDateTime),
                new UserMongo("Zhumakhanov Almas", "2002-06-29", "87025557777", "87775553333", currentDateTime)
        };

        repository.saveAll(Arrays.asList(users));
    }
    @PreDestroy
    private void deleteData(){
        repository.deleteAll();
    }

    }

