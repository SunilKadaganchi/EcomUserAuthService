package dev.sunil.EcomUserAuthService.service;

import dev.sunil.EcomUserAuthService.dto.RoleRequestDTO;
import dev.sunil.EcomUserAuthService.dto.RoleResponseDTO;

import java.util.List;

public interface RoleService {
    public RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO);
    public List<RoleResponseDTO> getAllRoles();
}
