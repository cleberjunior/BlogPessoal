package br.com.montreal.blog.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository repository;

    private PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioEntity save(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNome(usuarioDTO.nome());
        usuario.setEmail(usuarioDTO.email());
        usuario.setSenha(passwordEncoder.encode(usuarioDTO.senha()));
        usuario.setFoto(usuarioDTO.foto());

        return repository.save(usuario);
    }

    public UsuarioEntity update(Long id, UsuarioDTO usuarioDTO) {
        UsuarioEntity usuario = repository.findById(id).get();
        usuario.setNome(usuarioDTO.nome());
        usuario.setEmail(usuarioDTO.email());
        usuario.setSenha(passwordEncoder.encode(usuarioDTO.senha()));
        usuario.setFoto(usuarioDTO.foto());

        return repository.save(usuario);
    }

    public boolean delete(Long id) {
        UsuarioEntity usuario = repository.findById(id).get();
        if (usuario != null) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<UsuarioEntity> listarAll(){
        List<UsuarioEntity> usuarios = repository.findAll();
        return usuarios;
    }

    public UsuarioEntity findById(Long id) {
        return repository.findById(id).get();
    }
}
