package br.com.portal.noticia.dto;

import br.com.portal.noticia.entity.Usuario;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


    @Getter
    public class UserDetailsDTO implements UserDetails {

        private Usuario user; // Classe de usuário que criamos anteriormente

        public UserDetailsDTO(Usuario user) {
            this.user = user;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return List.of(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
        }

        @Override
        public String getPassword() {
            return user.getSenha();
        } // Retorna a credencial do usuário que criamos anteriormente

        @Override
        public String getUsername() {
            return user.getLogin();
        } // Retorna o nome de usuário do usuário que criamos anteriormente

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
            return true;
        }

    }
