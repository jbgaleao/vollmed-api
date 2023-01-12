package med.voll.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.models.medico.Medico;
import med.voll.api.models.medico.MedicoDTO;
import med.voll.api.models.paciente.Paciente;
import med.voll.api.repository.IMedicoRepository;
import med.voll.api.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private IMedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid MedicoDTO medicoDTO) {

        repository.save(new Medico(medicoDTO));
    }

}
