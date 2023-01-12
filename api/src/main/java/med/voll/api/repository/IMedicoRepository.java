package med.voll.api.repository;

import med.voll.api.models.medico.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicoRepository extends JpaRepository<Medico, Long> {

}
