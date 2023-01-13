package med.voll.api.models.paciente;

public record ListagemPacienteDTO(
        String nome,
        String email,
        String cpf
) {

        public ListagemPacienteDTO(Paciente paciente) {
                this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
        }
}

