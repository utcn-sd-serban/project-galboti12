package ro.utcn.sd.boti.heavyequipment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.boti.heavyequipment.entity.User;
import ro.utcn.sd.boti.heavyequipment.exception.UserNotFoundException;
import ro.utcn.sd.boti.heavyequipment.repository.RepositoryFactory;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{
    private final RepositoryFactory repositoryFactory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repositoryFactory.getUserRepository().findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Unknown user!"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }

    @Transactional
    public User loadCurrentUser() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return repositoryFactory.getUserRepository().findByUsername(name).orElseThrow(UserNotFoundException::new);
    }
}
