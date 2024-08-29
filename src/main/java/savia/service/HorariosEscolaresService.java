package savia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import savia.entity.HorariosEscolares;
import savia.repository.HorariosEscolaresRepository;

@Service
public class HorariosEscolaresService {
	
	@Autowired
	private HorariosEscolaresRepository horariosEscolaresRepository;
	
	public String save(HorariosEscolares horarioEscolar) {
			this.horariosEscolaresRepository.save(horarioEscolar);
			return "Cadastro realizado com sucesso!";
	}
	
	public String update(HorariosEscolares horarioEscolar, Long id) {
		horarioEscolar.setIdHorarioEscolar(id);
		this.horariosEscolaresRepository.save(horarioEscolar);
		return "Cadastro atualizado com sucesso!";
	}
	
	public String deleteById(Long Id) {
		this.horariosEscolaresRepository.deleteById(Id);
		return "Cadastro deletado com sucesso!";
	}

	public HorariosEscolares findById(Long Id) {
		Optional<HorariosEscolares> horarioEscolar = this.horariosEscolaresRepository.findById(Id);
		return horarioEscolar.get();
	}

	public List<HorariosEscolares> findAll() {
		List<HorariosEscolares> listaHorariosEscolares = this.horariosEscolaresRepository.findAll();
		return listaHorariosEscolares;
	}
}
