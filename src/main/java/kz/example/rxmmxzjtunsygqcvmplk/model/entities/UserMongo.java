package kz.example.rxmmxzjtunsygqcvmplk.model.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static kz.example.rxmmxzjtunsygqcvmplk.constants.UserSwaggerConstants.*;

@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserMongo {

    @Schema(description = USER_ID_DESCRIPTION, example = USER_ID_STRING_EXAMPLE)
    @Id
    private String id;

    @Schema(description = USER_NAME_DESCRIPTION, example = USER_NAME_EXAMPLE)
    private String name;

    @Schema(description = USER_DATE_OF_BIRTH_DESCRIPTION, example = USER_DATE_OF_BIRTH_EXAMPLE)
    private LocalDate dateOfBirth;

    @Schema(description = USER_FIRST_PHONE_NUMBER_DESCRIPTION, example = USER_FIRST_PHONE_NUMBER_EXAMPLE)
    private String firstPhoneNumber;

    @Schema(description = USER_SECOND_PHONE_NUMBER_DESCRIPTION, example = USER_SECOND_PHONE_NUMBER_EXAMPLE)
    private String secondPhoneNumber;

    @Schema(description = USER_DATE_CREATE_TIME_DESCRIPTION, example = USER_DATE_CREATE_TIME_EXAMPLE)
    @CreatedDate
    private LocalDateTime createDateTime;


    public UserMongo(String name, String dateOfBirth, String firstPhoneNumber, String secondPhoneNumber, LocalDateTime createDateTime) {
        this.name = name;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
        this.firstPhoneNumber = firstPhoneNumber;
        this.secondPhoneNumber = secondPhoneNumber;
        this.createDateTime = createDateTime;
    }
}
