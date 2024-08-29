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

import savia.entity.Professores;
import savia.service.ProfessoresService;

@RestController
@RequestMapping("/api/professor")
public class ProfessoresController {
@Autowired
private ProfessoresService professoresService;

@PostMapping("/save")
public ResponseEntity<String> save(@RequestBody Professores professor){
	try {
		String mensagem = this.professoresService.save(professor);
		return new ResponseEntity<String>(mensagem, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<String>("Erro ao cadastrar o professor", HttpStatus.BAD_GATEWAY);
	}
}
@PutMapping("/update")
public ResponseEntity<String> update(@RequestBody Professores professor){
	try {
		String mensagem = this.professoresService.update(professor, professor.getIdProfessor());
		return new ResponseEntity<String> (mensagem, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<String>("Erro ao atualizar o professor", HttpStatus.BAD_GATEWAY);
	}
}

@GetMapping("/findById/{id}")
public ResponseEntity<Professores> findById(@PathVariable Long id){
	try {
		Professores professor = this.professoresService.findById(id);
		return new ResponseEntity<Professores>(professor, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<>(null,HttpStatus.BAD_GATEWAY);
	}
}
@GetMapping("/findAll")
public ResponseEntity<List<Professores>> findAll(){
	try {
		List<Professores> professores = this.professoresService.findAll();
		return new ResponseEntity<List<Professores>>(professores, HttpStatus.OK);			
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);			
	}
}
@DeleteMapping("/deleteById/{id}")
public ResponseEntity<String> deleteById(@PathVariable Long id){
	try {
		String mensagem = this.professoresService.deleteById(id);
		return new ResponseEntity<String>(mensagem, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
	}
}
}
