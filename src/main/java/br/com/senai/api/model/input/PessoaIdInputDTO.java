package br.com.senai.api.model.input;

import br.com.senai.api.model.UsuarioDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PessoaIdInputDTO {

    @NotBlank
    private String nome;

    @NotNull
    private UsuarioInputDTO usuario;

    @NotBlank
    private String telephone;

}
