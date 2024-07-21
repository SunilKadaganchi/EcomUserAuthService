package dev.sunil.EcomUserAuthService.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Ecom_Role")
@Getter
@Setter
public class Role extends BaseModel{
    private String roleName;
    private String description;
}
