package kz.example.rxmmxzjtunsygqcvmplk.mapper;

import kz.example.rxmmxzjtunsygqcvmplk.model.dto.UserGetMongoDto;
import kz.example.rxmmxzjtunsygqcvmplk.model.dto.UserGetPostgresDto;
import kz.example.rxmmxzjtunsygqcvmplk.model.dto.UserRequestMongoDto;
import kz.example.rxmmxzjtunsygqcvmplk.model.dto.UserRequestPostgresDto;
import kz.example.rxmmxzjtunsygqcvmplk.model.entities.UserMongo;
import kz.example.rxmmxzjtunsygqcvmplk.model.entities.UserPostgres;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMongo mapToUserMongoEntity(UserRequestMongoDto userRequestMongoDto);
    UserPostgres mapToUserPostgresEntity(UserRequestPostgresDto userRequestPostgresDto);
    UserPostgres mapToUserPostgresEntity(@MappingTarget UserPostgres userPostgres, UserRequestPostgresDto userRequestPostgresDto);
    UserMongo mapToUserMongoEntity(@MappingTarget UserMongo userMongo, UserRequestMongoDto userRequestMongoDto);
    UserGetMongoDto mapToUserMongoDto(UserMongo userMongo);
    UserGetPostgresDto mapToUserPostgresDto(UserPostgres userPostgres);

}
