package com.ust.claims;

import com.ust.claims.api.user.UserEntity;
import com.ust.claims.api.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

    @Autowired
    UserRepository repo;

    @Test
    public void testCreateUser(){
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String rawPassword="gilgamesh";
        String encodedPassword= passwordEncoder.encode(rawPassword);

        UserEntity newUser=new UserEntity("235749@ust.com",encodedPassword);

        UserEntity savedUser= (UserEntity) repo.save(newUser);

        assert(savedUser).getUserId()>0;
        assert(savedUser.getEmail()).endsWith(".com");
    }
}