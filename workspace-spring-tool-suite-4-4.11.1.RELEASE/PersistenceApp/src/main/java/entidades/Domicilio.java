package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity
@Table (name ="domicilio")
@Audited
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Domicilio implements Serializable {
	
	/*================= atributos =================*/
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "nombre_calle")
	@NonNull private String nombreCalle;
	
	@Column(name ="numero")
	@NonNull private int numero;
	
	
}
