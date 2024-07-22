package dev.sunil.EcomUserAuthService.service;

import dev.sunil.EcomUserAuthService.dto.LoginRequestDTO;
import dev.sunil.EcomUserAuthService.dto.SignupRequestDTO;
import dev.sunil.EcomUserAuthService.dto.UserResponseDTO;

public interface UserService {
    public UserResponseDTO signup(SignupRequestDTO signupRequestDTO);
    public UserResponseDTO login(LoginRequestDTO loginRequestDTO);
    public boolean logout(String token);
    public boolean validate(String token);
}
