package kz.example.rxmmxzjtunsygqcvmplk.services.impl;

import kz.example.rxmmxzjtunsygqcvmplk.exception.NotFoundException;
import kz.example.rxmmxzjtunsygqcvmplk.mapper.UserMapper;
import kz.example.rxmmxzjtunsygqcvmplk.model.dto.Filter;
import kz.example.rxmmxzjtunsygqcvmplk.model.dto.UserGetPostgresDto;
import kz.example.rxmmxzjtunsygqcvmplk.model.dto.UserPostPostgresDto;
import kz.example.rxmmxzjtunsygqcvmplk.model.entities.UserPostgres;
import kz.example.rxmmxzjtunsygqcvmplk.repositories.UserPostgresRepository;
import kz.example.rxmmxzjtunsygqcvmplk.services.UserPostgresService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserPostgresServiceImpl implements UserPostgresService {

    private final UserPostgresRepository repository;
    private final UserMapper mapper;

    @Override
    @Transactional
    public UserGetPostgresDto createUser(UserPostPostgresDto userPostDto) {
        UserPostgres userPostgres = mapper.mapToUserPostgresEntity(userPostDto);
        repository.save(userPostgres);
        return mapper.mapToUserPostgresDto(userPostgres);
    }

    @Override
    @Transactional
    public UserGetPostgresDto updateUser(UserPostPostgresDto userPostDto) {
        UserPostgres userPostgres = repository.findById(userPostDto.getId())
                .orElseThrow(()->new NotFoundException("user with id: " +userPostDto.getId() +" not found"));
        userPostgres = mapper.mapToUserPostgresEntity(userPostgres, userPostDto);
        repository.save(userPostgres);
        return mapper.mapToUserPostgresDto(userPostgres);
    }

    @Override
    public UserGetPostgresDto getById(Long id) {
        UserPostgres userPostgres = repository.findById(id)
                .orElseThrow(()->new NotFoundException("user with id: " +id +" not found"));
        return mapper.mapToUserPostgresDto(userPostgres);
    }

    @Override
    public UserGetPostgresDto getByPhoneNumber(String phoneNumber) {
        UserPostgres userPostgres = repository.findByFirstPhoneNumberOrSecondPhoneNumber(phoneNumber)
                .orElseThrow(()->new NotFoundException("user with phone number: " + phoneNumber + " not found"));
        return mapper.mapToUserPostgresDto(userPostgres);
    }

    @Override
    public Page<UserGetPostgresDto> getAll(Filter filter) {
        Pageable pageable = PageRequest.of(filter.getOffset(), filter.getLimit());
        return repository.findAll(pageable)
                .map(mapper::mapToUserPostgresDto);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
         repository.deleteById(id);
    }
}
