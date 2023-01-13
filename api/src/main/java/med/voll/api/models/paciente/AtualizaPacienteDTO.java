package med.voll.api.models.paciente;

import med.voll.api.models.endereco.EnderecoDTO;

public record AtualizaPacienteDTO(
        Long id,
        String nome,
        String telefone,
        EnderecoDTO enderecoDTO
) {
}
