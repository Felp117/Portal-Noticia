package br.com.portalNoticia.service;

import br.com.portalNoticia.entity.Usuario;
import br.com.portalNoticia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario validacao(String nome, String senha) {
        usuarioRepository.findByLoginAndSenha(nome, senha);
        return null;
    }
}
