package savia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import savia.entity.Disciplinas;
import savia.repository.DisciplinasRepository;

@Service
public class DisciplinasService {
	@Autowired
	private DisciplinasRepository disciplinaRepository;
	
	public String save(Disciplinas disciplina) {
		this.disciplinaRepository.save(disciplina);
		return "Disciplina cadastrada com sucesso";
	}
	
	public String update(Disciplinas disciplina, Long id) {
		disciplina.setIdDisciplina(id);
		this.disciplinaRepository.save(disciplina);
		return "Disciplina atualizada com sucesso";
	}
	
	public String deleteById(Long id) {
		this.disciplinaRepository.deleteById(id);
		return "Disciplina deletada com sucesso";
	}
	
	public Disciplinas findById(Long id) {
		Optional<Disciplinas> disciplina = this.disciplinaRepository.findById(id);
		return disciplina.get();
	}
	
	public List<Disciplinas> findAll() {
		List<Disciplinas> listaDisciplinas = this.disciplinaRepository.findAll();
		return listaDisciplinas;
	}
}
