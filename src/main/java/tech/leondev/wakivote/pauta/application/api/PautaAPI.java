package tech.leondev.wakivote.pauta.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/pautas")
public interface PautaAPI {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    PautaResponseDTO salva(@RequestBody @Valid PautaRequestDTO pautaRequestDTO);
}
