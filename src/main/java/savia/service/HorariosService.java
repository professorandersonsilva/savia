package savia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import savia.entity.Horarios;
import savia.repository.HorariosRepository;

@Service
public class HorariosService {
	
	@Autowired
	private HorariosRepository horariosRepository;
	
	public String save(Horarios horario) {
		this.horariosRepository.save(horario);
		return "Horário cadastrado com sucesso";
	}
	
	public String update(Horarios horario, Long id) {
		this.horariosRepository.save(horario);
		return "Horário atualizado com sucesso";
	}
	
	public String deleteById(Long id) {
		this.horariosRepository.deleteById(id);
		return "Horário deletado com sucesso";
	}
	
	public Horarios findById(Long id) {
		Optional<Horarios> horario = this.horariosRepository.findById(id);
		return horario.get();
	}
	
	public List<Horarios> findAll() {
		List<Horarios> listaHorarios = this.horariosRepository.findAll();
		return listaHorarios;
	}
}
