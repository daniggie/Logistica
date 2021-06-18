package br.com.senai.api.model;
import br.com.senai.domain.model.StatusEntrega;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class EntregaModel {

    private Long id;

    private String nomePessoa;

    private DestinatarioModel destinatario;

    private BigDecimal taxa;

    private StatusEntrega status;

    private LocalDateTime dataPedido;

    private LocalDateTime dataFinalizacao;

}
