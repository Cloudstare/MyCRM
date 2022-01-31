package com.feli.mycrm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
    List<Users> findByLoginContaining(String login);
    @Query("SELECT u FROM Users u WHERE u.isDeleted = 0")
    List<Users> findAllActive();
    @Query("SELECT u FROM Users u WHERE u.isDeleted = 1")
    List<Users> findAllNActive();
}
