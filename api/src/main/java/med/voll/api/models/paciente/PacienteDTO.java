package med.voll.api.models.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.models.endereco.EnderecoDTO;

public record PacienteDTO(

        @NotBlank(message = "Campo obrigatório")
        String nome,

        @NotBlank(message = "Campo obrigatório")
        @Email
        String email,

        @NotNull
        Boolean ativo,

        @NotBlank(message = "Campo obrigatório")
        @Pattern(regexp = "\\d{11}")
        String telefone,

        @NotBlank(message = "Campo obrigatório")
        @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}")
        String cpf,

        @NotNull(message = "Campo obrigatório")
        @Valid
        EnderecoDTO endereco
) {
}
