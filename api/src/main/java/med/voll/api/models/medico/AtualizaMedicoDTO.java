package med.voll.api.models.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.models.endereco.EnderecoDTO;

public record AtualizaMedicoDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoDTO enderecoDTO
) {
}
