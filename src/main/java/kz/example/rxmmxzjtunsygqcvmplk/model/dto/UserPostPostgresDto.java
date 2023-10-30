package kz.example.rxmmxzjtunsygqcvmplk.model.dto;



import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserPostPostgresDto {
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private String firstPhoneNumber;
    private String secondPhoneNumber;
}
