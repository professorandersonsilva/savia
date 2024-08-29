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

import savia.entity.Turmas;
import savia.service.TurmasService;

@RestController
@RequestMapping("/api/turma")
public class TurmasController {
@Autowired
private TurmasService turmasService;

@PostMapping("/save")
public ResponseEntity<String> save(@RequestBody Turmas turma){
	try {
		String mensagem = this.turmasService.save(turma);
		return new ResponseEntity<String>(mensagem, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<String>("Erro ao cadastrar a turma", HttpStatus.BAD_GATEWAY);
	}
}
@PutMapping("/update")
public ResponseEntity<String> update(@RequestBody Turmas turma){
	try {
		String mensagem = this.turmasService.update(turma, turma.getIdTurma());
		return new ResponseEntity<String> (mensagem, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<String>("Erro ao atualizar a turma", HttpStatus.BAD_GATEWAY);
	}
}

@GetMapping("/findById/{id}")
public ResponseEntity<Turmas> findById(@PathVariable Long id){
	try {
		Turmas turma = this.turmasService.findById(id);
		return new ResponseEntity<Turmas>(turma, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<>(null,HttpStatus.BAD_GATEWAY);
	}
}
@GetMapping("/findAll")
public ResponseEntity<List<Turmas>> findAll(){
	try {
		List<Turmas> turmas = this.turmasService.findAll();
		return new ResponseEntity<List<Turmas>>(turmas, HttpStatus.OK);			
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);			
	}
}
@DeleteMapping("/deleteById/{id}")
public ResponseEntity<String> deleteById(@PathVariable Long id){
	try {
		String mensagem = this.turmasService.deleteById(id);
		return new ResponseEntity<String>(mensagem, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
	}
}
}
