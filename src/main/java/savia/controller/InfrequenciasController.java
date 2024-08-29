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

import savia.entity.Infrequencias;
import savia.service.InfrequenciasService;

@RestController
@RequestMapping("/api/infrequencia")
public class InfrequenciasController {

	@Autowired
	private InfrequenciasService infrequenciasService;

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Infrequencias infrequencia){
		try {
			String mensagem = this.infrequenciasService.save(infrequencia);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro ao cadastrar a infrequencia", HttpStatus.BAD_GATEWAY);
		}
	}
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Infrequencias infrequencia){
		try {
			String mensagem = this.infrequenciasService.update(infrequencia, infrequencia.getIdInfrequencia());
			return new ResponseEntity<String> (mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro ao atualizar a infrequencia", HttpStatus.BAD_GATEWAY);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Infrequencias> findById(@PathVariable Long id){
		try {
			Infrequencias infrequencia = this.infrequenciasService.findById(id);
			return new ResponseEntity<Infrequencias>(infrequencia, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_GATEWAY);
		}
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Infrequencias>> findAll(){
		try {
			List<Infrequencias> infrequencias = this.infrequenciasService.findAll();
			return new ResponseEntity<List<Infrequencias>>(infrequencias, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);			
		}
	}
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		try {
			String mensagem = this.infrequenciasService.deleteById(id);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
		}
	}
}
