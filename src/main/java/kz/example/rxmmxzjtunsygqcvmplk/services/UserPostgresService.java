package kz.example.rxmmxzjtunsygqcvmplk.services;

import kz.example.rxmmxzjtunsygqcvmplk.model.dto.Filter;
import kz.example.rxmmxzjtunsygqcvmplk.model.dto.UserGetPostgresDto;
import kz.example.rxmmxzjtunsygqcvmplk.model.dto.UserRequestPostgresDto;
import org.springframework.data.domain.Page;

public interface UserPostgresService {
    UserGetPostgresDto createUser(UserRequestPostgresDto userPostDto);

    UserGetPostgresDto updateUser(UserRequestPostgresDto userPostDto);

    UserGetPostgresDto getById(Long id);

    UserGetPostgresDto getByPhoneNumber(String phoneNumber);

    Page<UserGetPostgresDto> getAll(Filter filter);

    void deleteById(Long id);


}
