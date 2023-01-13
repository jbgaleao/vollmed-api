package med.voll.api.models.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.models.endereco.Endereco;
import med.voll.api.models.enums.Especialidade;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;
    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(MedicoDTO medicoDTO) {
        this.nome = medicoDTO.nome();
        this.email = medicoDTO.email();
        this.crm = medicoDTO.crm();
        this.telefone = medicoDTO.telefone();
        this.ativo = true;
        this.especialidade = medicoDTO.especialidade();
        this.endereco = new Endereco(medicoDTO.endereco());
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
