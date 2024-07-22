package dev.sunil.EcomUserAuthService.dto;

import dev.sunil.EcomUserAuthService.entity.Role;
import dev.sunil.EcomUserAuthService.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserResponseDTO {
    private String name;
    private String email;
    private String token;
    private List<RoleResponseDTO> roles;

    public static UserResponseDTO from(User user){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setToken(user.getToken());

        List<RoleResponseDTO> roleList = new ArrayList<>();
        for(Role r : user.getRoles()){
            RoleResponseDTO roleResponseDTO = new RoleResponseDTO();
            roleResponseDTO.setName(r.getRoleName());
            roleResponseDTO.setDescription(r.getDescription());
            roleList.add(roleResponseDTO);
        }

         return userResponseDTO;
    }
}
