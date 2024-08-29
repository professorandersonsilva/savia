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

import savia.entity.Disciplinas;
import savia.service.DisciplinasService;

@RestController
@RequestMapping("/api/disciplina")
public class DisciplinasController {
	
	@Autowired
	DisciplinasService disciplinasService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Disciplinas disciplina){
		try {
			String mensagem = this.disciplinasService.save(disciplina);
			return new ResponseEntity<String> (mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String> ("Erro ao cadastrar disciplina", HttpStatus.BAD_GATEWAY);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Disciplinas disciplina){
		try {
			String mensagem = this.disciplinasService.update(disciplina, disciplina.getIdDisciplina());
			return new ResponseEntity<String> (mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String> ("Erro ao atualizar a disciplina", HttpStatus.BAD_GATEWAY);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Disciplinas> findById(@PathVariable Long id){
		try {
			Disciplinas disciplina = this.disciplinasService.findById(id);
			return new ResponseEntity<Disciplinas>(disciplina, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);

		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Disciplinas>> findAll(){
		try {
			List<Disciplinas> listaDisciplinas = this.disciplinasService.findAll();
			return new ResponseEntity<List<Disciplinas>>(listaDisciplinas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);

		}
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		try {
			String message = this.disciplinasService.deleteById(id);
			return new ResponseEntity<String>(message,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_GATEWAY);
		}
	}
	
}
