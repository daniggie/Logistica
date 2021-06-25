package br.com.senai.domain.service;

import br.com.senai.api.assembler.RoleUsuarioAssembler;
import br.com.senai.api.model.RoleUsuarioDTO;
import br.com.senai.domain.model.RoleUsuarios;
import br.com.senai.domain.repository.RoleUsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoleUsuariosService {

    private RoleUsuarioRepository roleUsuarioRepository;
    private RoleUsuarioAssembler roleUsuarioAssembler;

    public RoleUsuarios cadastrar(RoleUsuarioDTO roleUsuarioDTO) {
        RoleUsuarios newRoleUsuarios = roleUsuarioAssembler.toEntity(roleUsuarioDTO);
        return roleUsuarioRepository.save(newRoleUsuarios);
    }
}
