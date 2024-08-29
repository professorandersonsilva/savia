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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Professores {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProfessor;
	private String matricula;
	private String nome;
	private String cep;
	private String tipoLogradouro;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String pais;
	private String cpf;
	private String dataNascimento;
	private String tipoLotacao;
	private String obs;
	private int cargaHoraria;
	
	@OneToMany(mappedBy = "professor")
	private List<HorariosEscolares> horariosEscolares;
	
	@OneToMany(mappedBy = "professor")
	private List<Infrequencias> infrequencias;
}
