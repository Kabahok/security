package com.egoravdeev.cleaning_service.service;

import com.egoravdeev.cleaning_service.dto.RegistrationUserDto;
import com.egoravdeev.cleaning_service.model.User;
import com.egoravdeev.cleaning_service.repositories.RoleRepository;
import com.egoravdeev.cleaning_service.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public Optional<User> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByLogin(username).orElseThrow(() -> new UsernameNotFoundException(
                String.format("Пользователь %s не найден", username)
        ));
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList())
        );
    }

    public void createdNewUser(RegistrationUserDto registrationUserDto) {
        User user = new User();
        user.setLogin(registrationUserDto.getLogin());
        user.setEmail(registrationUserDto.getEmail());
        user.setPassword(passwordEncoder.encode(registrationUserDto.getPassword()));
        user.setName(registrationUserDto.getName());
        user.setRoles(List.of(roleRepository.findByName("ROLE_USER").get()));
        user.setCreated(new Date());

        userRepository.save(user);
    }
}
