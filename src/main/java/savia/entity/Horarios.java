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
public class Horarios {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long idHorario;
 private String descricao;
 private String horaInicio;
 private String horaFim;
 
 @OneToMany(mappedBy = "horario")
 private List<HorariosEscolares> horariosEscolares;
 
 @OneToMany(mappedBy = "horario")
 private List<Infrequencias> infrequencias;
 
}
