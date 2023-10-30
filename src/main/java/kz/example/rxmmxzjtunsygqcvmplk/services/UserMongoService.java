package kz.example.rxmmxzjtunsygqcvmplk.services;

import kz.example.rxmmxzjtunsygqcvmplk.model.dto.*;
import org.springframework.data.domain.Page;

public interface UserMongoService {
    UserGetMongoDto createUser(UserRequestMongoDto userPostDto);

    UserGetMongoDto updateUser(UserRequestMongoDto userPostDto);

    UserGetMongoDto getById(String id);

    UserGetMongoDto getByPhoneNumber(String phoneNumber);

    Page<UserGetMongoDto> getAll(Filter filter);

    void deleteById(String id);
}
