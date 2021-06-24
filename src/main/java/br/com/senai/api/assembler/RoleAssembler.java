package br.com.senai.api.assembler;

import br.com.senai.api.model.RoleDTO;
import br.com.senai.api.model.RoleUsuarioDTO;
import br.com.senai.domain.model.Role;
import br.com.senai.domain.model.RoleUsuarios;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class RoleAssembler {

    private ModelMapper modelMapper;

    public RoleDTO toModel(Role role){
        return modelMapper.map(role, RoleDTO.class);
    }

    public Role toEntity(RoleDTO roleDTO){
        return modelMapper.map(roleDTO, Role.class);
    }

}
