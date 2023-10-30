package kz.example.rxmmxzjtunsygqcvmplk.model.entities;

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
public class UserMongo {
    @Id
    private String id;
    private String name;
    private LocalDate dateOfBirth;
    private String firstPhoneNumber;
    private String secondPhoneNumber;
    @CreationTimestamp
    private LocalDateTime createDateTime;


    public UserMongo(String name, String dateOfBirth, String firstPhoneNumber, String secondPhoneNumber, LocalDateTime createDateTime) {
        this.name = name;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
        this.firstPhoneNumber = firstPhoneNumber;
        this.secondPhoneNumber = secondPhoneNumber;
        this.createDateTime = createDateTime;
    }
}
