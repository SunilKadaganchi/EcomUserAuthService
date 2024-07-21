package dev.sunil.EcomUserAuthService.controller;

import dev.sunil.EcomUserAuthService.dto.LoginRequestDTO;
import dev.sunil.EcomUserAuthService.dto.SignupRequestDTO;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody SignupRequestDTO signupRequestDTO){
        return null;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO loginRequestDTO){
        return null;
    }

    @GetMapping("/logout")
    public  ResponseEntity logout(@RequestHeader("Authorization") String token){
        return null;
    }

    @GetMapping("/validate")
    public ResponseEntity validate(@RequestHeader("Authorization") String token){
        return null;
    }
}
