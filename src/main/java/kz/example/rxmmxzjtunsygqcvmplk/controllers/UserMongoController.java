package kz.example.rxmmxzjtunsygqcvmplk.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import kz.example.rxmmxzjtunsygqcvmplk.model.dto.Filter;
import kz.example.rxmmxzjtunsygqcvmplk.model.dto.UserGetMongoDto;
import kz.example.rxmmxzjtunsygqcvmplk.model.dto.UserRequestMongoDto;
import kz.example.rxmmxzjtunsygqcvmplk.services.UserMongoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static kz.example.rxmmxzjtunsygqcvmplk.constants.UserSwaggerConstants.*;

@RestController
@RequestMapping("/user/mongo")
@RequiredArgsConstructor
@Tag(name = NAME_OF_USER_MONGO_CONTROLLER, description = DESCRIPTION_OF_USER_MONGO_CONTROLLER)
public class UserMongoController {

    private final UserMongoService service;

    @Operation(description = DESCRIPTION_OF_CREATE_USER_API)
    @PostMapping
    public ResponseEntity<UserGetMongoDto> createUser(@Valid @RequestBody UserRequestMongoDto userRequestMongoDto){
        return ResponseEntity.ok(service.createUser(userRequestMongoDto));
    }

    @Operation(description = DESCRIPTION_OF_UPDATE_USER_API)
    @PutMapping
    public ResponseEntity<UserGetMongoDto> updateUser(@Valid @RequestBody UserRequestMongoDto userRequestMongoDto){
        return ResponseEntity.ok(service.updateUser(userRequestMongoDto));
    }

    @Operation(description = DESCRIPTION_OF_GET_USER_BY_ID_API)
    @GetMapping("/id/{id}")
    public ResponseEntity<UserGetMongoDto> getById(@PathVariable String id){
        return ResponseEntity.ok(service.getById(id));
    }

    @Operation(description = DESCRIPTION_OF_GET_USER_BY_PHONE_NUMBER_API)
    @GetMapping("/phoneNumber/{phoneNumber}")
    public ResponseEntity<UserGetMongoDto> getByPhoneNumber(@PathVariable String phoneNumber){
        return ResponseEntity.ok(service.getByPhoneNumber(phoneNumber));
    }

    @Operation(description = DESCRIPTION_OF_GET_ALL_USER_API)
    @GetMapping("/all")
    public ResponseEntity<Page<UserGetMongoDto>> getAll(@RequestBody Filter filter){

        return ResponseEntity.ok(service.getAll(filter));
    }

    @Operation(description = DESCRIPTION_OF_DELETE_USER_BY_ID_API)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
