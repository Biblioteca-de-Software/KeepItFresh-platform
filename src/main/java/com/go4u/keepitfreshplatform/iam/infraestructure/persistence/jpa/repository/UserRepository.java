package com.go4u.keepitfreshplatform.iam.infraestructure.persistence.jpa.repository;
import com.go4u.keepitfreshplatform.iam.domain.model.aggregates.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByUsername(String username);


    boolean existsByUsername(String username);
}
