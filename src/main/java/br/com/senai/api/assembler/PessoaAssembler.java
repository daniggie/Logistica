package br.com.senai.api.assembler;

import br.com.senai.api.model.PessoaModel;
import br.com.senai.api.model.input.EntregaInput;
import br.com.senai.domain.model.Entrega;
import br.com.senai.domain.model.Pessoa;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class PessoaAssembler {

    private ModelMapper modelMapper;

    public PessoaModel toModel(Pessoa pessoa){
        return modelMapper.map(pessoa, PessoaModel.class);
    }

    public List<PessoaModel> toCollectionModel(List<Pessoa> pessoas){
        return pessoas.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Entrega toEntity(EntregaInput entregaInput){
        return modelMapper.map(entregaInput, Entrega.class);
    }


}
