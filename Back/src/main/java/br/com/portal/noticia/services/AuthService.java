package br.com.portal.noticia.services;

import br.com.portal.noticia.configuration.SecurityConfig;
import br.com.portal.noticia.dto.LoginDTO;
import br.com.portal.noticia.dto.RecoveryJwtDTO;
import br.com.portal.noticia.dto.UserDetailsDTO;
import br.com.portal.noticia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private SecurityConfig securityConfiguration;

    public RecoveryJwtDTO authenticateUser(LoginDTO loginUserDto) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginUserDto.getLogin(), loginUserDto.getSenha());

        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        UserDetailsDTO userDetails = (UserDetailsDTO) authentication.getPrincipal();

        return new RecoveryJwtDTO(jwtTokenService.generateToken(userDetails));
    }
}
