package entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Table(name ="detalle_factura")
@Audited
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DetalleFactura implements Serializable{
	
	/*================= atributos =================*/
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="cantidad")
	private int cantidad;
	
	@Column (name="subtotal")
	private int subtotal;
	
	/*================= relaciones =================*/
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="fk_articulo")
	private Articulo articulo;
	

}
