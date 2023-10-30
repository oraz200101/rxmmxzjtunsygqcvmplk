package kz.example.rxmmxzjtunsygqcvmplk.model.entities.postgres;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
