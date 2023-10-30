package kz.example.rxmmxzjtunsygqcvmplk.mapper;

import kz.example.rxmmxzjtunsygqcvmplk.model.dto.UserGetMongoDto;
import kz.example.rxmmxzjtunsygqcvmplk.model.dto.UserGetPostgresDto;
import kz.example.rxmmxzjtunsygqcvmplk.model.dto.UserPostDto;
import kz.example.rxmmxzjtunsygqcvmplk.model.entities.UserMongo;
import kz.example.rxmmxzjtunsygqcvmplk.model.entities.UserPostgres;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMongo mapToUserMongoEntity(UserPostDto userPostDto);
    UserPostgres mapToUserPostgresEntity(UserPostDto userPostDto);
    UserGetMongoDto mapToUserMongoDto(UserMongo userMongo);
    UserGetPostgresDto mapToUserPostgresDto(UserPostgres userPostgres);

}
