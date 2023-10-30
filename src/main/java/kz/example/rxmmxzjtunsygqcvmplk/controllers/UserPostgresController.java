package kz.example.rxmmxzjtunsygqcvmplk.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import kz.example.rxmmxzjtunsygqcvmplk.model.dto.*;
import kz.example.rxmmxzjtunsygqcvmplk.services.UserPostgresService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static kz.example.rxmmxzjtunsygqcvmplk.constants.UserSwaggerConstants.*;

@RestController
@RequestMapping("/user/postgres")
@RequiredArgsConstructor
@Tag(name = NAME_OF_USER_POSTGRES_CONTROLLER, description = DESCRIPTION_OF_USER_POSTGRES_CONTROLLER)
public class UserPostgresController {

    private final UserPostgresService service;

    @Operation(description = DESCRIPTION_OF_CREATE_USER_API)
    @PostMapping
    public ResponseEntity<UserGetPostgresDto> createUser(@Valid @RequestBody UserRequestPostgresDto userRequestPostgresDto) {
        return ResponseEntity.ok(service.createUser(userRequestPostgresDto));
    }

    @Operation(description = DESCRIPTION_OF_UPDATE_USER_API)
    @PutMapping
    public ResponseEntity<UserGetPostgresDto> updateUser(@Valid @RequestBody UserRequestPostgresDto userRequestPostgresDto) {
        return ResponseEntity.ok(service.updateUser(userRequestPostgresDto));
    }

    @Operation(description = DESCRIPTION_OF_GET_USER_BY_ID_API)
    @GetMapping("/id/{id}")
    public ResponseEntity<UserGetPostgresDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Operation(description = DESCRIPTION_OF_GET_USER_BY_PHONE_NUMBER_API)
    @GetMapping("/phoneNumber/{phoneNumber}")
    public ResponseEntity<UserGetPostgresDto> getByPhoneNumber(@PathVariable String phoneNumber) {
        return ResponseEntity.ok(service.getByPhoneNumber(phoneNumber));
    }

    @Operation(description = DESCRIPTION_OF_GET_ALL_USER_API)
    @GetMapping("/all")
    public ResponseEntity<Page<UserGetPostgresDto>> getAll(@RequestBody Filter filter) {
        return ResponseEntity.ok(service.getAll(filter));
    }

    @Operation(description = DESCRIPTION_OF_DELETE_USER_BY_ID_API)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
