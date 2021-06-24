package br.com.senai.api.controller;

import br.com.senai.api.assembler.RoleUsuarioAssembler;
import br.com.senai.api.model.RoleUsuarioDTO;
import br.com.senai.domain.model.Role;
import br.com.senai.domain.model.RoleUsuarios;
import br.com.senai.domain.service.RoleUsuariosService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/roles/usuarios")
public class RoleUsuarioController {

    private RoleUsuariosService roleUsuariosService;
    private RoleUsuarioAssembler roleUsuarioAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrar(@Valid @RequestBody RoleUsuarioDTO roleUsuarioDTO){
        RoleUsuarios roleUsuariosCadastrar = roleUsuariosService.cadastrar(roleUsuarioDTO);
    }
}