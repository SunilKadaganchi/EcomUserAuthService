package dev.sunil.EcomUserAuthService.service;

import dev.sunil.EcomUserAuthService.dto.RoleRequestDTO;
import dev.sunil.EcomUserAuthService.dto.RoleResponseDTO;
import dev.sunil.EcomUserAuthService.entity.Role;
import dev.sunil.EcomUserAuthService.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO) {
        Role saveRole = new Role();
        saveRole.setRoleName(roleRequestDTO.getName());
        saveRole.setDescription(roleRequestDTO.getDescription());

        saveRole = roleRepository.save(saveRole);
        return RoleResponseDTO.from(saveRole);
    }

    @Override
    public List<RoleResponseDTO> getAllRoles() {
        List<Role> roles  = roleRepository.findAll();
        List<RoleResponseDTO> roleResponseDTOList = new ArrayList<>();
        for(Role r : roles){
            RoleResponseDTO roleResponseDTO = RoleResponseDTO.from(r);
            roleResponseDTOList.add(roleResponseDTO);
        }
        return roleResponseDTOList;
    }
}
