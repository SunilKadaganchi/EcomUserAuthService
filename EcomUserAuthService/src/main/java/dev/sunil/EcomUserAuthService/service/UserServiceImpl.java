package dev.sunil.EcomUserAuthService.service;

import dev.sunil.EcomUserAuthService.dto.LoginRequestDTO;
import dev.sunil.EcomUserAuthService.dto.SignupRequestDTO;
import dev.sunil.EcomUserAuthService.dto.UserResponseDTO;
import dev.sunil.EcomUserAuthService.entity.Role;
import dev.sunil.EcomUserAuthService.entity.User;
import dev.sunil.EcomUserAuthService.exception.EmailAlreadyExistException;
import dev.sunil.EcomUserAuthService.exception.InvalidCredentialsException;
import dev.sunil.EcomUserAuthService.exception.RoleNotFoundException;
import dev.sunil.EcomUserAuthService.repository.RoleRepository;
import dev.sunil.EcomUserAuthService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserResponseDTO signup(SignupRequestDTO signupRequestDTO) {
        Role role = roleRepository.findById(signupRequestDTO.getRoleId()).orElseThrow(()->new RoleNotFoundException("Role Not found with the given RoleId"));

        Optional<User> isUserPresent =userRepository.findByEmail(signupRequestDTO.getEmail());
        if(isUserPresent.isPresent()){
            throw new EmailAlreadyExistException("Email Already Exists");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User saveUser = new User();
        saveUser.setEmail(signupRequestDTO.getEmail());
        saveUser.setName(signupRequestDTO.getName());
        saveUser.setPassword(encoder.encode(signupRequestDTO.getPassword()));
        saveUser.setRoles(List.of(role));
        saveUser = userRepository.save(saveUser);

        return UserResponseDTO.from(saveUser);
    }

    @Override
    public UserResponseDTO login(LoginRequestDTO loginRequestDTO) {
        User user =userRepository.findByEmail(loginRequestDTO.getEmail()).orElseThrow(
                ()->new InvalidCredentialsException("Email is Not Valid"));
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean isPasswordCorrect = encoder.matches(loginRequestDTO.getPassword(), user.getPassword());
        if(isPasswordCorrect){
            String userData = user.getEmail()+ LocalDateTime.now()+user.getPassword();
            String token = encoder.encode(userData);
            user.setToken(token);
            user = userRepository.save(user);
            UserResponseDTO userResponseDTO = UserResponseDTO.from(user);
            userResponseDTO.setToken(token);

            return userResponseDTO;
        }
        else{
            throw new InvalidCredentialsException("Password is Not correct");
        }
    }

    @Override
    public boolean logout(String token) {
        Optional<User> user = userRepository.findByToken(token);
        if(user.isPresent()){
            user.get().setToken(null);
             userRepository.save(user.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean validate(String token) {
        User user = userRepository.findByToken(token).orElseThrow(()->
                new InvalidCredentialsException("Token is Invalid"));

        return true;
    }
}
