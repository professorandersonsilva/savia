package savia.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HorariosEscolares {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idHorarioEscolar;
	private String dia;
	
	@ManyToOne
	private Horarios horario;
	
	@ManyToOne
	private Disciplinas disciplina;
	
	@ManyToOne
	private Professores professor;
}
