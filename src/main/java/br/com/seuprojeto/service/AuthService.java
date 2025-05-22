package br.com.seuprojeto.service;

import br.com.seuprojeto.dto.*;
import br.com.seuprojeto.model.Role;
import br.com.seuprojeto.model.Usuario;
import br.com.seuprojeto.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder; // Adicione esta linha

    // Método de LOGIN (existente)
    public TokenResponse login(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getSenha())
        );

        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        String jwtToken = jwtService.generateToken(usuario);
        return new TokenResponse(jwtToken, "Seja bem-vindo, " + usuario.getNome() + "!");
    }

    // Novo método de CADASTRO
    public TokenResponse cadastrar(CadastroRequest request) {
        // Verifica se e-mail já existe
        if (usuarioRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("E-mail já cadastrado");
        }

        // Cria novo usuário
        Usuario usuario = new Usuario();
        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        usuario.setSenha(passwordEncoder.encode(request.getSenha())); // Criptografa a senha
        usuario.setRole(Role.USER); // Define como USER por padrão

        usuarioRepository.save(usuario);

        // Gera token automaticamente após cadastro
        String jwtToken = jwtService.generateToken(usuario);
        return new TokenResponse(jwtToken, "Cadastro realizado! Seja bem-vindo, " + usuario.getNome() + "!");
    }
}