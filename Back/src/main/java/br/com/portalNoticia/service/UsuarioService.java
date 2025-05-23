package br.com.portalNoticia.service;

import br.com.portalNoticia.entity.Usuario;
import br.com.portalNoticia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario){
        return this.usuarioRepository.save(usuario);
    }


    public Usuario validation(String nome, String senha) {
        return usuarioRepository.findByLoginAndSenha(nome, senha);
    }


}
