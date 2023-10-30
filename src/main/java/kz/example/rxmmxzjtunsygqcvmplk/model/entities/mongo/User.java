package kz.example.rxmmxzjtunsygqcvmplk.model.entities.mongo;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "first_phone_number")
    private String firstPhoneNumber;

    @Column(name = "second_phone_number")
    private String secondPhoneNumber;

    @Column(name = "create_date_time")
    @CreationTimestamp
    private LocalDateTime createDateTime;
}
