package kz.example.rxmmxzjtunsygqcvmplk.services;

import kz.example.rxmmxzjtunsygqcvmplk.model.dto.Filter;
import kz.example.rxmmxzjtunsygqcvmplk.model.dto.UserGetPostgresDto;
import kz.example.rxmmxzjtunsygqcvmplk.model.dto.UserPostPostgresDto;
import org.springframework.data.domain.Page;

public interface UserPostgresService {
    UserGetPostgresDto createUser(UserPostPostgresDto userPostDto);

    UserGetPostgresDto updateUser(UserPostPostgresDto userPostDto);

    UserGetPostgresDto getById(Long id);

    UserGetPostgresDto getByPhoneNumber(String phoneNumber);

    Page<UserGetPostgresDto> getAll(Filter filter);

    void deleteById(Long id);


}
