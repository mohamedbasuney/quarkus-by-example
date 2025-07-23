package de.schulte.smartbar.backoffice;

import io.quarkus.security.jpa.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@UserDefinition
@Table(name = "sbo_User")
public class User extends BaseEntity{
    @Username
    public String username;
    @Password()
    public String password;
    @Roles
    public String roles;
}
