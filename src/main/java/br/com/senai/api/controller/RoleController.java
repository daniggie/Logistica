package br.com.senai.api.controller;

import br.com.senai.api.assembler.RoleAssembler;
import br.com.senai.api.model.RoleDTO;
import br.com.senai.domain.model.Role;
import br.com.senai.domain.service.RoleService;
  import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@AllArgsConstructor
@RestController
@RequestMapping("/roles")
public class RoleController {

    private RoleService roleService;
    private RoleAssembler roleAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrar(@Valid @RequestBody RoleDTO roleDTO){
        Role roleCadastrar = roleService.cadastrar(roleDTO);
    }
}
