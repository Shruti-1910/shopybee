package com.alpha.shopybeebackend.services;

import com.alpha.shopybeebackend.exception.Authentication.EmailAlreadyPresentException;
import com.alpha.shopybeebackend.exception.Authentication.EmailNotFoundException;
import com.alpha.shopybeebackend.exception.Authentication.EmailPasswordNotMatchingException;
import com.alpha.shopybeebackend.models.User;
import com.alpha.shopybeebackend.respositories.UserRepository;
import com.alpha.shopybeebackend.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserService(UserRepository repository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    // Login method
    public String login(User user) {
        List<User> users = repository.findByEmail(user.getEmail());
        if (users.isEmpty()) {
            throw new EmailNotFoundException("No email address found");
        }

        User foundUser = users.getFirst();
        if (passwordEncoder.matches(user.getPassword(), foundUser.getPassword())) {
            // Generate JWT token upon successful login
            return jwtTokenProvider.generateToken(foundUser.getEmail());
        } else {
            throw new EmailPasswordNotMatchingException("Incorrect password");
        }
    }

    // Register new user method with password encryption
    public User registerNewUser(User user) {
        if (repository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyPresentException("This email already exists, Try logging in!");
        }
        // Encode the user's password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public User getById(Long id) {
        return repository.findById(id).orElseThrow();
    }
}
