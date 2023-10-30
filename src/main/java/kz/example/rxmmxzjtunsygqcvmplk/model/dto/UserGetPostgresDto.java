package kz.example.rxmmxzjtunsygqcvmplk.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static kz.example.rxmmxzjtunsygqcvmplk.constants.UserSwaggerConstants.*;


@Getter
@Setter
@AllArgsConstructor
@Schema(title = USER_POSTGRES_MONGO_DTO_TITLE)
public class UserGetPostgresDto {

    @Schema(description = USER_ID_DESCRIPTION, example = USER_ID_LONG_EXAMPLE)
    private Long id;

    @Schema(description = USER_NAME_DESCRIPTION, example = USER_NAME_EXAMPLE)
    private String name;

    @Schema(description = USER_DATE_OF_BIRTH_DESCRIPTION, example = USER_DATE_OF_BIRTH_EXAMPLE)
    private LocalDate dateOfBirth;

    @Schema(description = USER_FIRST_PHONE_NUMBER_DESCRIPTION, example = USER_FIRST_PHONE_NUMBER_EXAMPLE)
    private String firstPhoneNumber;

    @Schema(description = USER_SECOND_PHONE_NUMBER_DESCRIPTION, example = USER_SECOND_PHONE_NUMBER_EXAMPLE)
    private String secondPhoneNumber;

    @Schema(description = USER_DATE_CREATE_TIME_DESCRIPTION, example = USER_DATE_CREATE_TIME_EXAMPLE)
    private LocalDateTime createDateTime;
}
