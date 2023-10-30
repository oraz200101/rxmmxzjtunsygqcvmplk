package kz.example.rxmmxzjtunsygqcvmplk.controllers;

import kz.example.rxmmxzjtunsygqcvmplk.model.dto.*;
import kz.example.rxmmxzjtunsygqcvmplk.services.UserPostgresService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/postgres")
@RequiredArgsConstructor
public class UserPostgresController {

    private final UserPostgresService service;


    @PostMapping
    public ResponseEntity<UserGetPostgresDto> createUser(@RequestBody UserRequestPostgresDto userRequestPostgresDto){
        return ResponseEntity.ok(service.createUser(userRequestPostgresDto));
    }

    @PutMapping
    public ResponseEntity<UserGetPostgresDto> updateUser(@RequestBody UserRequestPostgresDto userRequestPostgresDto){
        return ResponseEntity.ok(service.updateUser(userRequestPostgresDto));
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<UserGetPostgresDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }
    @GetMapping("/phoneNumber/{phoneNumber}")
    public ResponseEntity<UserGetPostgresDto> getByPhoneNumber(@PathVariable String phoneNumber){
        return ResponseEntity.ok(service.getByPhoneNumber(phoneNumber));
    }
    @GetMapping("/all")
    public ResponseEntity<Page<UserGetPostgresDto>> getAll(@RequestBody Filter filter){
        return ResponseEntity.ok(service.getAll(filter));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
