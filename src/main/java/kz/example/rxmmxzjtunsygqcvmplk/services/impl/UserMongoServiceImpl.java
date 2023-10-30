package kz.example.rxmmxzjtunsygqcvmplk.services.impl;

import kz.example.rxmmxzjtunsygqcvmplk.exception.NotFoundException;
import kz.example.rxmmxzjtunsygqcvmplk.mapper.UserMapper;
import kz.example.rxmmxzjtunsygqcvmplk.model.dto.Filter;
import kz.example.rxmmxzjtunsygqcvmplk.model.dto.UserGetMongoDto;
import kz.example.rxmmxzjtunsygqcvmplk.model.dto.UserPostMongoDto;
import kz.example.rxmmxzjtunsygqcvmplk.model.entities.UserMongo;
import kz.example.rxmmxzjtunsygqcvmplk.repositories.mongo.UserMongoRepository;
import kz.example.rxmmxzjtunsygqcvmplk.services.UserMongoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserMongoServiceImpl implements UserMongoService {

    private final UserMongoRepository repository;
    private final UserMapper mapper;

    @Override
    @Transactional
    public UserGetMongoDto createUser(UserPostMongoDto userPostDto) {
        UserMongo userMongo = mapper.mapToUserMongoEntity(userPostDto);
        repository.save(userMongo);
        return mapper.mapToUserMongoDto(userMongo);
    }

    @Override
    @Transactional
    public UserGetMongoDto updateUser(UserPostMongoDto userPostDto) {
        UserMongo userMongo = repository.findById(userPostDto.getId())
                .orElseThrow(() -> new NotFoundException("user with id: " + userPostDto.getId() + " not found"));
        userMongo = mapper.mapToUserMongoEntity(userMongo, userPostDto);
        repository.save(userMongo);
        return mapper.mapToUserMongoDto(userMongo);
    }

    @Override
    public UserGetMongoDto getById(String id) {
        UserMongo userMongo = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("user with id: " +id+ " not found"));
        return mapper.mapToUserMongoDto(userMongo);
    }

    @Override
    public UserGetMongoDto getByPhoneNumber(String phoneNumber) {
        UserMongo userMongo = repository.findByPhoneNumber(phoneNumber)
                .orElseThrow(()->new NotFoundException("user with phone number: " +phoneNumber+ " not found"));;
        return mapper.mapToUserMongoDto(userMongo);
    }

    @Override
    public Page<UserGetMongoDto> getAll(Filter filter) {
        Pageable pageable = PageRequest.of(filter.getOffset(), filter.getLimit());
        return repository.findAll(pageable).map(mapper::mapToUserMongoDto);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
       repository.deleteById(id);
    }
}
