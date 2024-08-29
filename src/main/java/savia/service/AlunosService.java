package savia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import savia.entity.Alunos;
import savia.repository.AlunosRepository;

@Service
public class AlunosService {
	
	@Autowired
	private AlunosRepository alunosRepository;
	
	public String save(Alunos aluno) {
		this.alunosRepository.save(aluno);
		return "Aluno cadastrado com sucesso";
	}
	
	public String update(Alunos aluno, Long Id) {
		aluno.setIdAluno(Id);
		this.alunosRepository.save(aluno);
		return "Aluno atualizado com sucesso";
	}
	
	public String deleteById(Long Id) {
		this.alunosRepository.deleteById(Id);
		return "Aluno deletado com sucesso";
	}
	
	public Alunos findById(Long Id) {
		Optional<Alunos> aluno = this.alunosRepository.findById(Id);
		return aluno.get();
	}
	
	public List<Alunos> findAll() {
		List<Alunos> alunos = this.alunosRepository.findAll();
		return alunos;
	}
}
