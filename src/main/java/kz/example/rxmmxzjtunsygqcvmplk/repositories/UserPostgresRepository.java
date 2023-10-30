package kz.example.rxmmxzjtunsygqcvmplk.repositories;

import kz.example.rxmmxzjtunsygqcvmplk.model.entities.UserPostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPostgresRepository extends JpaRepository<UserPostgres, Long> {
}
