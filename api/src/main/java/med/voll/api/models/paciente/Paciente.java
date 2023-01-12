package med.voll.api.models.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.models.endereco.Endereco;

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

    @Embedded
    private Endereco endereco;


    public Paciente(PacienteDTO pacienteDTO) {
        this.email = pacienteDTO.email();
        this.endereco = new Endereco(pacienteDTO.endereco());
        this.cpf = pacienteDTO.cpf();
        this.nome= pacienteDTO.nome();
        this.telefone= pacienteDTO.telefone();
    }
}
