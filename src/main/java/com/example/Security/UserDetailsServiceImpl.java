package com.example.Security;

import com.example.Models.User.User;
import com.example.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("UserDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    public UserDetailsServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    private final UserRepository repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=repo.findByNickname(username).orElseThrow(
                ()->new UsernameNotFoundException("User doesn`t exists!")
        );

        return UserSecurity.fromUser(user);
    }
}
