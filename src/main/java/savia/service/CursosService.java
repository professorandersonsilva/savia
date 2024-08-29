package savia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import savia.entity.Cursos;
import savia.repository.CursosRepository;

@Service
public class CursosService {
	@Autowired
	private CursosRepository cursoRepository;
	
	public String save(Cursos curso) {
		this.cursoRepository.save(curso);
		return "Curso cadastrado com sucesso";
	}
	
	public String update(Cursos curso, Long id) {
		curso.setIdCurso(id);
		this.cursoRepository.save(curso);
		return "Curso atualizado com sucesso";
	}
	
	public String deleteById(Long id) {
		this.cursoRepository.deleteById(id);
		return "Curso deletado com sucesso";
	}
	
	public Cursos findById(Long id) {
		Optional<Cursos> curso = this.cursoRepository.findById(id);
		return curso.get();
	}
	
	public List<Cursos> findAll(){
		List<Cursos> cursos = this.cursoRepository.findAll();
		return cursos;
	}
	
}
