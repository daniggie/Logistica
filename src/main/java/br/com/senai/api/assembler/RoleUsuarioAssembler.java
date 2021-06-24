package br.com.senai.api.assembler;

import br.com.senai.api.model.RoleUsuarioDTO;
import br.com.senai.domain.model.RoleUsuarios;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class RoleUsuarioAssembler {

    private ModelMapper modelMapper;

    public RoleUsuarioDTO toModel(RoleUsuarios roleUsuarios){
        return modelMapper.map(roleUsuarios, RoleUsuarioDTO.class);
    }

    public RoleUsuarios toEntity(RoleUsuarioDTO roleUsuarioDTO){
        return modelMapper.map(roleUsuarioDTO, RoleUsuarios.class);
    }


}
