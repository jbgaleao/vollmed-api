package med.voll.api.models.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.models.endereco.Endereco;
import med.voll.api.models.medico.AtualizaMedicoDTO;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private Boolean ativo;

    @Embedded
    private Endereco endereco;

    public Paciente(PacienteDTO pacienteDTO) {
        this.email = pacienteDTO.email();
        this.endereco = new Endereco(pacienteDTO.endereco());
        this.cpf = pacienteDTO.cpf();
        this.nome = pacienteDTO.nome();
        this.telefone = pacienteDTO.telefone();
    }

    public void atualizarPaciente(AtualizaPacienteDTO pacienteDTO) {
        if (pacienteDTO.nome() != null) {
            this.nome = pacienteDTO.nome();
        }
        if (pacienteDTO.telefone() != null) {
            this.telefone = pacienteDTO.telefone();
        }
        if (pacienteDTO.enderecoDTO() != null) {
            this.endereco.atualizarEndereco(pacienteDTO.enderecoDTO());
        }
    }

    public void atualizarMedico(AtualizaMedicoDTO medicoDTO) {
        if (medicoDTO.nome() != null) {
            this.nome = medicoDTO.nome();
        }
        if (medicoDTO.telefone() != null) {
            this.telefone = medicoDTO.telefone();
        }
        if (medicoDTO.enderecoDTO() != null) {
            this.endereco.atualizarEndereco(medicoDTO.enderecoDTO());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
