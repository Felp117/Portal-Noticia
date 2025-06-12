package br.com.portal.noticia.services;

import br.com.portal.noticia.dto.UserDetailsDTO;
import br.com.portal.noticia.entity.Usuario;
import br.com.portal.noticia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> user = userRepository.findByLogin(username);

        return user.map(UserDetailsDTO::new).orElse(null);
    }
}