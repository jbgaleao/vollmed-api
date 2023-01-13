package med.voll.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.models.paciente.ListagemPacienteDTO;
import med.voll.api.models.paciente.Paciente;
import med.voll.api.models.paciente.PacienteDTO;
import med.voll.api.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("paciente")
public class PacienteController {
    @Autowired
    private IPacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid PacienteDTO pacienteDTO) {
        repository.save(new Paciente(pacienteDTO));
    }

    @GetMapping
    public Page<ListagemPacienteDTO> listar(@PageableDefault(page = 0, size = 10, sort = {"nome"}) Pageable page) {
        return repository.findAll(page).map(ListagemPacienteDTO::new);
    }
}
