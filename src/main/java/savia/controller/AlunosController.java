package savia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import savia.entity.Alunos;
import savia.service.AlunosService;

@RestController
@RequestMapping("/api/aluno")
public class AlunosController {
	@Autowired
	AlunosService alunosService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Alunos aluno){
		try {
			String mensagem = this.alunosService.save(aluno);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro ao cadastrar o aluno", HttpStatus.BAD_GATEWAY);
		}
	}
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Alunos aluno){
		try {
			String mensagem = this.alunosService.update(aluno, aluno.getIdAluno());
			return new ResponseEntity<String> (mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro ao atualizar o aluno", HttpStatus.BAD_GATEWAY);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Alunos> findById(@PathVariable Long id){
		try {
			Alunos aluno = this.alunosService.findById(id);
			return new ResponseEntity<Alunos>(aluno, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_GATEWAY);
		}
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Alunos>> findAll(){
		try {
			List<Alunos> alunos = this.alunosService.findAll();
			return new ResponseEntity<List<Alunos>>(alunos, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);			
		}
	}
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		try {
			String mensagem = this.alunosService.deleteById(id);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
		}
	}
}
