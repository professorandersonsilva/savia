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

import savia.entity.Cursos;
import savia.service.CursosService;

@RestController
@RequestMapping("/api/curso")
public class CursosController {
	@Autowired
	private CursosService cursosService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Cursos curso){
		try {
			String mensagem = this.cursosService.save(curso);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro ao cadastrar o curso", HttpStatus.BAD_GATEWAY);
		}
	}
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Cursos curso){
		try {
			String mensagem = this.cursosService.update(curso, curso.getIdCurso());
			return new ResponseEntity<String> (mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro ao atualizar o curso", HttpStatus.BAD_GATEWAY);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Cursos> findById(@PathVariable Long id){
		try {
			Cursos curso = this.cursosService.findById(id);
			return new ResponseEntity<Cursos>(curso, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_GATEWAY);
		}
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Cursos>> findAll(){
		try {
			List<Cursos> cursos = this.cursosService.findAll();
			return new ResponseEntity<List<Cursos>>(cursos, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);			
		}
	}
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		try {
			String mensagem = this.cursosService.deleteById(id);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
		}
	}
}
