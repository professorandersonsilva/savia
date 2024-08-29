package savia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import savia.entity.Turmas;
import savia.repository.TurmasRepository;

@Service
public class TurmasService {
	@Autowired
	private TurmasRepository turmasRepository;
	
	public String save(Turmas turma) {
		this.turmasRepository.save(turma);
		return "Turma cadastrada com sucesso";
	}
	
	public String update(Turmas turma, Long id) {
		turma.setIdTurma(id);
		this.turmasRepository.save(turma);
		return "Turma atualizada com sucesso";
	}
	
	public String deleteById(Long id) {
		this.turmasRepository.deleteById(id);
		return "Turma deletada com sucesso";
	}
	
	public Turmas findById(Long id) {
		Optional<Turmas> turma = this.turmasRepository.findById(id);
		return turma.get();
	}
	
	public List<Turmas> findAll(){
		List<Turmas> turma = this.turmasRepository.findAll();
		return turma;
	}
}
