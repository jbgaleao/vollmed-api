package med.voll.api.models.medico;

import med.voll.api.models.enums.Especialidade;


public record ListagemMedicoDTO(
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {

    public ListagemMedicoDTO(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());

    }
}
