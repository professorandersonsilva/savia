package savia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import savia.entity.Infrequencias;
import savia.repository.InfrequenciasRepository;

@Service
public class InfrequenciasService {
	@Autowired
	private InfrequenciasRepository infrequenciaRepository;
	
	public String save(Infrequencias infrequencia) {
		this.infrequenciaRepository.save(infrequencia);
		return "Infrequência cadastrada com sucesso";
	}
	
	public String update(Infrequencias infrequencia, Long id) {
		infrequencia.setIdInfrequencia(id);
		this.infrequenciaRepository.save(infrequencia);
		return "Infrequência atualizada com sucesso";
	}
	
	public String deleteById(Long id) {
		this.infrequenciaRepository.deleteById(id);
		return "Infrequência deletada com sucesso";
	}
	
	public Infrequencias findById(Long id) {
		Optional<Infrequencias> infrequencia = this.infrequenciaRepository.findById(id);
		return infrequencia.get();
	}
	
	public List<Infrequencias> findAll(){
		List<Infrequencias> infrequencia = this.infrequenciaRepository.findAll();
		return infrequencia;
	}
}
