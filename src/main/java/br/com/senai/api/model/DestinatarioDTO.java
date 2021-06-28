package br.com.senai.api.model;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DestinatarioDTO {

    public String nome;
    public String logradouro;
    public String numero;
    public String complemento;
    public String bairro;

}
