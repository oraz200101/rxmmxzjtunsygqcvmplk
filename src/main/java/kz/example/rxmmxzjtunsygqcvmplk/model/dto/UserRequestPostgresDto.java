package kz.example.rxmmxzjtunsygqcvmplk.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import kz.example.rxmmxzjtunsygqcvmplk.annotations.PhoneNumberConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static kz.example.rxmmxzjtunsygqcvmplk.constants.UserSwaggerConstants.*;

@Getter
@Setter
@AllArgsConstructor
@Schema(title = USER_REQUEST_POSTGRES_DTO_TITLE)
public class UserRequestPostgresDto {

    @Schema(description = USER_ID_DESCRIPTION, example = USER_ID_LONG_EXAMPLE)
    private Long id;

    @Schema(description = USER_NAME_DESCRIPTION, example = USER_NAME_EXAMPLE)
    @NotEmpty(message = "name can not be empty")
    private String name;

    @Schema(description = USER_DATE_OF_BIRTH_DESCRIPTION, example = USER_DATE_OF_BIRTH_EXAMPLE)
    private LocalDate dateOfBirth;

    @Schema(description = USER_FIRST_PHONE_NUMBER_DESCRIPTION, example = USER_FIRST_PHONE_NUMBER_EXAMPLE)
    @NotEmpty(message = "first phone number can not be empty")
    @PhoneNumberConstraint
    private String firstPhoneNumber;

    @Schema(description = USER_SECOND_PHONE_NUMBER_DESCRIPTION, example = USER_SECOND_PHONE_NUMBER_EXAMPLE)
    @PhoneNumberConstraint
    private String secondPhoneNumber;
}
