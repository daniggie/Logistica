package br.com.senai.domain.service;

import br.com.senai.api.assembler.EntregaAssembler;
import br.com.senai.api.model.EntregaDTO;
import br.com.senai.domain.model.Entrega;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.model.StatusEntrega;
import br.com.senai.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

    private PessoaService pessoaService;
    private EntregaRepository entregaRepository;
    private EntregaAssembler entregaAssembler;

    public Entrega solicitar(Entrega entrega){
        Pessoa pessoa = pessoaService.buscar(entrega.getPessoa().getId());
        entrega.setPessoa(pessoa);

        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());

        return entregaRepository.save(entrega);
    }

    public List<EntregaDTO> listar(){

        return entregaAssembler.toCollectionModel(entregaRepository.findAll());
    }

    public ResponseEntity<EntregaDTO> buscar(Long entregaId) {
        return entregaRepository.findById(entregaId).map(entrega -> {
//            EntregaModel entregaModel = new EntregaModel();

//            entregaModel.setId(entrega.getId());
//            entregaModel.setNomePessoa(entrega.getPessoa().getNome());
//            entregaModel.setDestinatario(new DestinatarioModel());
//            entregaModel.getDestinatario().setNome(entrega.getDestinatario().getNome());
//            entregaModel.getDestinatario().setLogradouro(entrega.getDestinatario().getLogradouro());
//            entregaModel.getDestinatario().setNumero(entrega.getDestinatario().getNumero());
//            entregaModel.getDestinatario().setComplemento(entrega.getDestinatario().getComplemento());
//            entregaModel.getDestinatario().setBairro(entrega.getDestinatario().getBairro());
//            entregaModel.setTaxa(entrega.getTaxa());

            return ResponseEntity.ok(entregaAssembler.toModel(entrega));
        })
                .orElse(ResponseEntity.notFound().build());

    }

}
