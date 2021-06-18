package br.com.senai.domain.service;

import br.com.senai.domain.model.Entrega;
import br.com.senai.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class OcorrenciaService {

    private EntregaService entregaService;

    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao){
        Entrega entrega = entregaService.buscaEntrega(entregaId);

        return entrega.adicionaOcorrencia(descricao);
    }
}
