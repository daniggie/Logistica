package br.com.senai.domain.service;

import br.com.senai.domain.exception.NegocioException;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    @Transactional
    public Pessoa cadastrar(Pessoa pessoa){
        boolean emailValidation = pessoaRepository.findByEmail(pessoa.getEmail())
                .isPresent();

        if(emailValidation){
            throw new NegocioException("E-mail já está sendo utilizado");
        }

        return pessoaRepository.save(pessoa);

    }

    @Transactional
    public void excluir(Long pessoaId){
        pessoaRepository.deleteById(pessoaId);
    }

    public Pessoa buscar(Long pessoaId){
        return  pessoaRepository.findById(pessoaId)
                .orElseThrow(()->new NegocioException("Pessoa não encontrada."));
    }
}











