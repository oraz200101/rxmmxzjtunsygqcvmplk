package kz.example.rxmmxzjtunsygqcvmplk.model.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static kz.example.rxmmxzjtunsygqcvmplk.constants.UserSwaggerConstants.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users", schema = "phone_number_crud_schema")
public class UserPostgres {

    @Schema(description = USER_ID_DESCRIPTION, example = USER_ID_LONG_EXAMPLE)
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = USER_NAME_DESCRIPTION, example = USER_NAME_EXAMPLE)
    @Column(name = "name")
    private String name;

    @Schema(description = USER_DATE_OF_BIRTH_DESCRIPTION, example = USER_DATE_OF_BIRTH_EXAMPLE)
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Schema(description = USER_FIRST_PHONE_NUMBER_DESCRIPTION, example = USER_FIRST_PHONE_NUMBER_EXAMPLE)
    @Column(name = "first_phone_number")
    private String firstPhoneNumber;

    @Schema(description = USER_SECOND_PHONE_NUMBER_DESCRIPTION, example = USER_SECOND_PHONE_NUMBER_EXAMPLE)
    @Column(name = "second_phone_number")
    private String secondPhoneNumber;

    @Schema(description = USER_DATE_CREATE_TIME_DESCRIPTION, example = USER_DATE_CREATE_TIME_EXAMPLE)
    @Column(name = "create_date_time")
    @CreationTimestamp
    private LocalDateTime createDateTime;

}
