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

import savia.entity.Horarios;
import savia.service.HorariosService;

@RestController
@RequestMapping ("/api/horario")
public class HorariosController {
	
	@Autowired
	private HorariosService horariosService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Horarios horario){
		try {
			String mensagem = this.horariosService.save(horario);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Deu erro ao salvar!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Horarios horario){
		try {
			String mensagem = this.horariosService.update(horario, horario.getIdHorario());
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Deu erro ao salvar!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Horarios> findById(@PathVariable Long id){
		try {
			Horarios horario = this.horariosService.findById(id);
			return new ResponseEntity<Horarios>(horario, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Horarios>> findAll(){
		try {
			List<Horarios> listaHorarios = this.horariosService.findAll();
			return new ResponseEntity<List<Horarios>>(listaHorarios, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("deleteById/{id}")
	public ResponseEntity<String>deleteById(@PathVariable Long id){
		try {
			String mensagem = this.horariosService.deleteById(id);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
		}
	}
	
	
}
