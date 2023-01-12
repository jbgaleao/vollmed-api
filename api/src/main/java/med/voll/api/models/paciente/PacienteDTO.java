package med.voll.api.models.paciente;

import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.models.endereco.EnderecoDTO;
import med.voll.api.models.enums.Especialidade;
public record PacienteDTO(

        @NotBlank(message = "Campo obrigatório")
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{10,11}")
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}")
        String cpf,

        @NotNull
        @Valid
        EnderecoDTO endereco
) {
}
