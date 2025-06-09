package br.com.portalNoticia.services;

import br.com.portalNoticia.dto.LoginDTO;
import br.com.portalNoticia.dto.UsuarioDto;
import br.com.portalNoticia.entity.Pessoa;
import br.com.portalNoticia.entity.Usuario;
import br.com.portalNoticia.repository.UsuarioRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@CrossOrigin(origins = "*")
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> findAll(){
        return repository.findAll();
    }

    public Usuario findById(Integer id) throws BadRequestException {
        Optional<Usuario> usuario = repository.findById(id);
        if(usuario.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possivel encontrar o usuario com ID: " + id);
        }
        return usuario.get();
    }

    public void  login(LoginDTO dto) {
        Optional<Usuario> usuario = repository.findByLoginAndSenha(
                dto.getLogin(),
                dto.getSenha());
        if(usuario.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario/senha estão incorretos");
        }
    }

}
