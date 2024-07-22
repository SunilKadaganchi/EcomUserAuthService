package dev.sunil.EcomUserAuthService.dto;

import dev.sunil.EcomUserAuthService.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class RoleResponseDTO {
    private UUID roleId;
    private String name;
    private String description;


    public static RoleResponseDTO from(Role role){
        RoleResponseDTO roleResponseDTO = new RoleResponseDTO();
        roleResponseDTO.setName(role.getRoleName());
        roleResponseDTO.setDescription(role.getDescription());
        roleResponseDTO.setRoleId(role.getId());

        return roleResponseDTO;
    }
}
