package savia.entity;

import java.sql.Date;
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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Alunos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAluno;
	private String matricula, nome, cep, tipoLogradouro,
	logradouro, numero, complemento, bairro, cidade,
	uf, pais, cpf, obs;
	private Date dataNascimento;
	
	@OneToMany(mappedBy = "aluno")
	private List<Infrequencias> infrequencias;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Turmas turma;
}
