package tech.leondev.wakivote.associado.infra.client;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ConsultaCpfResponse {
    private String ni;
    private String nome;
    private Situacao situacao;
    private String nascimento;

    public boolean isInvalid() {
        return !this.isValid();
    }

    public boolean isValid(){
        return this.situacao.codigo.equals("0");
    }

    @Getter
    @ToString
    public static class Situacao {
        private String codigo;
        private String descricao;
    }
}
