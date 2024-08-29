package savia.entity;

import java.sql.Date;

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
@AllArgsConstructor
@NoArgsConstructor
public class Infrequencias {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInfrequencia;
	private Date data;
	
	@ManyToOne
	private Horarios horario;
	
	@ManyToOne
	private Alunos aluno;
	
	@ManyToOne
	private Professores professor;
	
}
