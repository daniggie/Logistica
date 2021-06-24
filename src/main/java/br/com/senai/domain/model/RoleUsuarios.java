package br.com.senai.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class RoleUsuarios {

    @Id
    private Long id;

    private String roleNomeRole;

    private Long usuarioId;

}
