package br.com.montreal.blog.user;

import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private UsuarioRepository repository;

    private PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario save(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.nome());
        usuario.setEmail(usuarioDTO.email());
        usuario.setSenha(passwordEncoder.encode(usuarioDTO.senha()));
        usuario.setFoto(usuarioDTO.foto());

        return repository.save(usuario);
    }

    public Usuario update(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuario = repository.findById(id).get();
        usuario.setNome(usuarioDTO.nome());
        usuario.setEmail(usuarioDTO.email());
        usuario.setSenha(passwordEncoder.encode(usuarioDTO.senha()));
        usuario.setFoto(usuarioDTO.foto());

        return repository.save(usuario);
    }

    public boolean delete(Long id) {
        Usuario usuario = repository.findById(id).get();
        if (usuario != null) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Usuario> listarAll(){
        List<Usuario> usuarios = repository.findAll();
        return usuarios;
    }

    public Usuario findById(Long id) {
        return repository.findById(id).get();
    }
}
