package kz.example.rxmmxzjtunsygqcvmplk.repositories;

import kz.example.rxmmxzjtunsygqcvmplk.model.entities.UserPostgres;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserPostgresRepository extends JpaRepository<UserPostgres, Long> {

    @Query("select u from UserPostgres u where u.firstPhoneNumber = ?1 or u.secondPhoneNumber = ?1")
    Optional<UserPostgres> findByFirstPhoneNumberOrSecondPhoneNumber(String phoneNumber);

}
