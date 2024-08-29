package savia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import savia.entity.Professores;
import savia.repository.ProfessoresRepository;

@Service
public class ProfessoresService {
	@Autowired
	private ProfessoresRepository professoresRepository;
	
	public String save(Professores professor) {
		this.professoresRepository.save(professor);
		return "Porfessor cadastrado com sucesso";
	}

	public String update(Professores professor, Long Id) {
		professor.setIdProfessor(Id);
		this.professoresRepository.save(professor);
		return "Porfessor atualizado com sucesso";
	}
	
	public String deleteById(Long Id) {
		this.professoresRepository.deleteById(Id);
		return "Porfessor deletado com sucesso";
	}
	
	public Professores findById(Long Id) {
		Optional <Professores> professor= this.professoresRepository.findById(Id);
		return professor.get();
	}

	public List<Professores> findAll() {
		List<Professores> professores= this.professoresRepository.findAll();
		return professores;
	}
}
