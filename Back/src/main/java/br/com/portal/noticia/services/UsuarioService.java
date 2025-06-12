package br.com.portal.noticia.services;

import br.com.portal.noticia.dto.LoginDTO;
import br.com.portal.noticia.dto.UsuarioDto;
import br.com.portal.noticia.entity.Pessoa;
import br.com.portal.noticia.entity.Usuario;
import br.com.portal.noticia.repository.PessoaRepository;
import br.com.portal.noticia.repository.UsuarioRepository;
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
    @Autowired
    private PessoaRepository pessoaRepository;


    public void  login(LoginDTO dto) {
        Optional<Usuario> usuario = repository.findByLoginAndSenha(
                dto.getLogin(),
                dto.getSenha());
        if(usuario.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario/senha estão incorretos");
        }
    }

    public void cadastrar(UsuarioDto dto) {
        Optional<Usuario> existente = repository.findByLogin(dto.getLogin());
        if (existente.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Login já está em uso");
        }

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.getNome());
        pessoa.setEmail(dto.getEmail());
        pessoaRepository.save(pessoa);

        Usuario usuario = new Usuario();
        usuario.setLogin(dto.getLogin());
        usuario.setSenha(dto.getSenha());
        usuario.setPessoa(pessoa);


        repository.save(usuario);
    }
}
