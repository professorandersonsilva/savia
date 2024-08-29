package savia.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Disciplinas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDisciplina;
	private String nome;
	private String area;
		
	@OneToMany(mappedBy = "disciplina")
	private List<HorariosEscolares> horariosEscolares;
 
	
}
