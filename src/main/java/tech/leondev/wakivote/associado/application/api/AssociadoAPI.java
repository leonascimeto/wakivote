package tech.leondev.wakivote.associado.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/associados")
public interface AssociadoAPI {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    AssociadoResponseDTO salva(@RequestBody @Valid AssociadoRequestDTO associadoRequestDTO);
}
