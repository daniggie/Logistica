package br.com.senai.api.controller;

import br.com.senai.api.assembler.EntregaAssembler;
import br.com.senai.api.assembler.RoleAssembler;
import br.com.senai.api.model.OcorrenciaDTO;
import br.com.senai.api.model.RoleDTO;
import br.com.senai.api.model.input.OcorrenciaInputDTO;
import br.com.senai.api.model.input.RoleInputDTO;
import br.com.senai.domain.model.Ocorrencia;
import br.com.senai.domain.model.Role;
import br.com.senai.domain.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/roles/{pessoaId}")
public class RoleController {

    private RoleAssembler roleAssembler;
    private RoleService roleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoleDTO cadastrar(@PathVariable Long pessoaId, @Valid @RequestBody RoleInputDTO roleInputDTO){
        Role newRole = roleService.cadastrar(pessoaId, roleInputDTO.getNome());


        return roleAssembler.toModel(newRole);
    }
}
