package ru.dom.lukmanovcarhiring.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dom.lukmanovcarhiring.app.dto.UserDto;
import ru.dom.lukmanovcarhiring.app.registr_auth.dao.entity.UserEntity;

@Service("userService")
@Transactional
public class UserService {

    @Autowired
    private UserDao dao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntity findByFirstName(String firstName) {
        UserEntity user = dao.findByFirstName(firstName);
        return user;
    }

    public void saveUser(UserDto user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.saveUser(user);
    }

}
