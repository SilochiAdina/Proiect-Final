package ro.siit.Proiect.Final.config;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.siit.Proiect.Final.Service.UserServiceImpl;

@Service
public class MyAppUserDetailsService implements UserDetailsService {

    @Autowired
    UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        System.out.println("---------1-------------");
        ro.siit.Proiect.Final.Model.User users=userService.searchIfUserExist(userName);
        GrantedAuthority authority = new SimpleGrantedAuthority("rol");
        UserDetails userDetails = (UserDetails)new User(users.getUsername(),
                users.getPassword(), Arrays.asList(authority));
        return userDetails;
    }
}