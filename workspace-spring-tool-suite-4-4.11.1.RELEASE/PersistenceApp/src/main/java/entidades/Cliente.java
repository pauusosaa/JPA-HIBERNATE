package entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity
@Table (name = "cliente")
@Audited
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class Cliente implements Serializable {
	
	/*================= atributos =================*/
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre")
	@NonNull private String nombre;
	
	@Column(name= "apellido")
	@NonNull private String apellido;
	
	@Column (name = "dni", unique = true)
	@NonNull private int dni;
	
	/*================= relaciones =================*/
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn (name = "fk_domicilio")
	private Domicilio domicilio;
	
	

}
