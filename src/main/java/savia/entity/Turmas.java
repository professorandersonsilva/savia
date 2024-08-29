package savia.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Turmas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTurma;
	private String nome;
	private int anoInicio;
	private int anoFim;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Cursos curso;
	
	@OneToMany(mappedBy = "turma")
	List <Alunos> alunos;
}
