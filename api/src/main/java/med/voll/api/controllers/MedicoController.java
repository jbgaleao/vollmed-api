package med.voll.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.models.medico.AtualizaMedicoDTO;
import med.voll.api.models.medico.ListagemMedicoDTO;
import med.voll.api.models.medico.Medico;
import med.voll.api.models.medico.MedicoDTO;
import med.voll.api.repository.IMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public Page<ListagemMedicoDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable page) {
        return repository.findAllByAtivoTrue(page).map(ListagemMedicoDTO::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizaMedicoDTO medicoDTO) {
        Medico medico = repository.getReferenceById(medicoDTO.id());
        medico.atualizarMedico(medicoDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        Medico medico = repository.getReferenceById(id);
        // repository.deleteById(id);
        medico.excluir();
    }

}
