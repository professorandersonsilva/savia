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

import savia.entity.HorariosEscolares;
import savia.service.HorariosEscolaresService;

@RestController
@RequestMapping("/api/horarioEscolar")
public class HorariosEscolaresController {
	@Autowired
	private HorariosEscolaresService horariosEscolaresService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody HorariosEscolares horarioEscolar){
		try {
			String mensagem = this.horariosEscolaresService.save(horarioEscolar);
			return new ResponseEntity<String> (mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String> ("Erro ao cadastrar o horarioEscolar", HttpStatus.BAD_GATEWAY);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody HorariosEscolares horarioEscolar){
		try {
			String mensagem = this.horariosEscolaresService.update(horarioEscolar, horarioEscolar.getIdHorarioEscolar());
			return new ResponseEntity<String> (mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String> ("Erro ao atualizar o horarioEscolar", HttpStatus.BAD_GATEWAY);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<HorariosEscolares> findById(@PathVariable Long id){
		try {
			HorariosEscolares horarioEscolar = this.horariosEscolaresService.findById(id);
			return new ResponseEntity<HorariosEscolares>(horarioEscolar, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);

		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<HorariosEscolares>> findAll(){
		try {
			List<HorariosEscolares> listaHorariosEscolares = this.horariosEscolaresService.findAll();
			return new ResponseEntity<List<HorariosEscolares>>(listaHorariosEscolares, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);

		}
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		try {
			String message = this.horariosEscolaresService.deleteById(id);
			return new ResponseEntity<String>(message,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_GATEWAY);
		}
	}

}
