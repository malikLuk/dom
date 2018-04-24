package ru.dom.lukmanovcarhiring.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dom.lukmanovcarhiring.app.dto.UserDto;
import ru.dom.lukmanovcarhiring.app.registr_auth.dao.entity.UserEntity;

import java.util.Arrays;
import java.util.List;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String firstName)
        throws UsernameNotFoundException {
        UserEntity userEntity = userService.findByFirstName(firstName);
        if(userEntity==null){
            throw new UsernameNotFoundException("Username not found");
        }
        return new User(userEntity.getFirstName(), userEntity.getPassword(),
            true, true, true, true, this.getAuthorities(userEntity));
    }

    private List<GrantedAuthority> getAuthorities(UserEntity userEntity) {
        return Arrays.asList(new SimpleGrantedAuthority(userEntity.getRole()));
    }

}
