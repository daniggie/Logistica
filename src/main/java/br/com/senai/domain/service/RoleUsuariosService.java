package br.com.senai.domain.service;

import br.com.senai.api.assembler.RoleUsuarioAssembler;
import br.com.senai.api.model.RoleUsuarioDTO;
import br.com.senai.domain.model.RoleUsuarios;
import br.com.senai.domain.repository.RoleUsuarioRepository;

public class RoleUsuariosService {

    private RoleUsuarioRepository roleUsuarioRepository;
    private RoleUsuarioAssembler roleUsuarioAssembler;

    public RoleUsuarios cadastrar(RoleUsuarioDTO roleUsuarioDTO) {
        RoleUsuarios newRoleUsuarios = roleUsuarioAssembler.toEntity(roleUsuarioDTO);
        return roleUsuarioRepository.save(newRoleUsuarios);
    }
}
