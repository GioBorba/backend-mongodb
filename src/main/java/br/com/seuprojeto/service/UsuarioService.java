package br.com.seuprojeto.service;

import br.com.seuprojeto.model.Usuario;
import br.com.seuprojeto.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(@Valid Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public Usuario autenticar(String email, String senha) {
        // Busca o usuário pelo email
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);

        if (usuarioOpt.isEmpty()) {
            return null;
        }

        Usuario usuario = usuarioOpt.get();

        if (!usuario.getSenha().equals(senha)) {
            return null; // senha inválida
        }

        return usuario;
    }
}
