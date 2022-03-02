package com.example.pdp_meal.config.security;

import com.example.pdp_meal.enums.Role;
import com.example.pdp_meal.enums.Status;
import com.example.pdp_meal.model.AuthUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;


@Getter
@Setter
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private Integer id;
    private String fullName;
    private String phone;
    private String username;
    private Status status;
    private String password;
    private String department;
    private String position;
    private boolean active;
    private Set<GrantedAuthority> authorities;

    public UserDetails(AuthUser user) {
        this.id = user.getId();
        this.fullName = user.getFullName();
        this.phone = user.getPhone();
        this.username = user.getUsername();
        this.status = user.getStatus();
        this.password = user.getPassword();
        this.department = user.getDepartment();
        this.position = user.getPosition();
        this.active = user.isActive();
        processAuthorities(user);
    }

    private void processAuthorities(AuthUser user) {
        authorities = new HashSet<>();
        String role = user.getRole();

        if (Objects.isNull(role)) return;
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
    }

    @Override

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.active;
    }
}
