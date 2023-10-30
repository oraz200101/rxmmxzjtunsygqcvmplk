package kz.example.rxmmxzjtunsygqcvmplk.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserGetPostgresDto {
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private String firstPhoneNumber;
    private String secondPhoneNumber;
    private LocalDateTime createDateTime;
}
