package med.voll.api.models.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.models.endereco.EnderecoDTO;
import med.voll.api.models.enums.Especialidade;

public record MedicoDTO(
        @NotBlank(message = "Campo obrigatório")
        String nome,
        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{10,11}")
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        Boolean ativo,

        @NotNull
        Especialidade especialidade,
        @NotNull
        @Valid
        EnderecoDTO endereco
) {
}
