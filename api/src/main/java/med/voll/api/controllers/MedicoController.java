package med.voll.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.models.medico.ListagemMedicoDTO;
import med.voll.api.models.medico.Medico;
import med.voll.api.models.medico.MedicoDTO;
import med.voll.api.repository.IMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public Page<ListagemMedicoDTO> listar(Pageable page) {
        return repository.findAll(page).map(ListagemMedicoDTO::new);
    }

}
