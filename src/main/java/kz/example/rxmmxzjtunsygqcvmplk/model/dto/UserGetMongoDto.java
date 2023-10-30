package kz.example.rxmmxzjtunsygqcvmplk.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class UserGetMongoDto {
    private String id;
    private String name;
    private LocalDate dateOfBirth;
    private String firstPhoneNumber;
    private String secondPhoneNumber;
    private LocalDateTime createDateTime;
}
