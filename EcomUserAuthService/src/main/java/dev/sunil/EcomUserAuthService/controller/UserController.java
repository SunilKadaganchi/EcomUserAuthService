package dev.sunil.EcomUserAuthService.controller;

import dev.sunil.EcomUserAuthService.dto.LoginRequestDTO;
import dev.sunil.EcomUserAuthService.dto.SignupRequestDTO;
import dev.sunil.EcomUserAuthService.dto.UserResponseDTO;
import dev.sunil.EcomUserAuthService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDTO> signup(@RequestBody SignupRequestDTO signupRequestDTO){
        return ResponseEntity.ok(userService.signup(signupRequestDTO));

    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity.ok(userService.login(loginRequestDTO));
    }

    @GetMapping("/logout")
    public  ResponseEntity<Boolean> logout(@RequestHeader("Authorization") String token){
        return ResponseEntity.ok(userService.logout(token));
    }

    @GetMapping("/validate")
    public ResponseEntity<Boolean> validate(@RequestHeader("Authorization") String token){
        return ResponseEntity.ok(userService.validate(token));
    }
}
