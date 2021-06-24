package br.com.senai.domain.service;

import br.com.senai.api.assembler.RoleAssembler;
import br.com.senai.api.model.RoleDTO;
import br.com.senai.domain.model.Role;
import br.com.senai.domain.repository.RoleRepository;

public class RoleService {

    private RoleRepository roleRepository;
    private RoleAssembler roleAssembler;

    public Role cadastrar(RoleDTO roleDTO) {
        Role newRole = roleAssembler.toEntity(roleDTO);
        return roleRepository.save(newRole);
    }
}
