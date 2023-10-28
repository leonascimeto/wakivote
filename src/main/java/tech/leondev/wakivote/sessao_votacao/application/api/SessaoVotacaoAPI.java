package tech.leondev.wakivote.sessao_votacao.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/sessao-votacoes")
public interface SessaoVotacaoAPI {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    SessaoVotacaoResponseDTO abreSessao(@RequestBody @Valid SessaoVotacaoRequestDTO sessaoVotacaoRequestDTO);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<SessaoVotacaoResponseDTO> listaSessao();

    @GetMapping("/{idSessaoVotacao}")
    @ResponseStatus(HttpStatus.OK)
    SessaoVotacaoDetalheResponseDTO buscaSessao(@PathVariable UUID idSessaoVotacao);

    @DeleteMapping("/{idSessaoVotacao}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletaSessao(@PathVariable UUID idSessaoVotacao);
}
