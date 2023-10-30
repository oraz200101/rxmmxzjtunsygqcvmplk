package kz.example.rxmmxzjtunsygqcvmplk.controllers;

import kz.example.rxmmxzjtunsygqcvmplk.model.dto.Filter;
import kz.example.rxmmxzjtunsygqcvmplk.model.dto.UserGetMongoDto;
import kz.example.rxmmxzjtunsygqcvmplk.model.dto.UserRequestMongoDto;
import kz.example.rxmmxzjtunsygqcvmplk.services.UserMongoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/mongo")
@RequiredArgsConstructor
public class UserMongoController {

    private final UserMongoService service;
    @PostMapping
    public ResponseEntity<UserGetMongoDto> createUser(@RequestBody UserRequestMongoDto userRequestMongoDto){
        return ResponseEntity.ok(service.createUser(userRequestMongoDto));
    }

    @PutMapping
    public ResponseEntity<UserGetMongoDto> updateUser(@RequestBody UserRequestMongoDto userRequestMongoDto){
        return ResponseEntity.ok(service.updateUser(userRequestMongoDto));
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<UserGetMongoDto> getById(@PathVariable String id){
        return ResponseEntity.ok(service.getById(id));
    }
    @GetMapping("/phoneNumber/{phoneNumber}")
    public ResponseEntity<UserGetMongoDto> getByPhoneNumber(@PathVariable String phoneNumber){
        return ResponseEntity.ok(service.getByPhoneNumber(phoneNumber));
    }
    @GetMapping("/all")
    public ResponseEntity<Page<UserGetMongoDto>> getAll(@RequestBody Filter filter){
        return ResponseEntity.ok(service.getAll(filter));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
