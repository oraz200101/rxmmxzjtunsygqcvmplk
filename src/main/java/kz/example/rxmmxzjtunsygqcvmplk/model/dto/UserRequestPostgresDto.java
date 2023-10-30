package kz.example.rxmmxzjtunsygqcvmplk.model.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class UserRequestPostgresDto {
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private String firstPhoneNumber;
    private String secondPhoneNumber;
}
