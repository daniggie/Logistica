package br.com.senai.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.ManyToMany;
import java.util.List;

public class Role implements GrantedAuthority {

    @Id
    private String nomeRole;

     
    private List<Usuario> usuarios;

    @Override
    public String getAuthority() {
        return this.nomeRole;
    }
}
