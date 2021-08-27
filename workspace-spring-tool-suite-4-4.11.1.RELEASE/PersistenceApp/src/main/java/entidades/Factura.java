package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;



@Entity
@Table (name="factura")
@Audited
public class Factura implements Serializable {
	
	/*================= atributos =================*/
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="fecha")
	private String fecha;
	
	@Column(name="numero")
	private int numero;
	
	@Column(name="total")
	private int total;
	
	/*================= relaciones =================*/
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="fk_cliente")
	private Cliente cliente;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();

	/*================= constructores =================*/
	
	public Factura() {
		
	}

	public Factura(String fecha, int numero) {
		
		this.fecha = fecha;
		this.numero = numero;
	}
	
	public Factura(String fecha, int numero, Cliente cliente) {
		super();
		this.fecha = fecha;
		this.numero = numero;
		this.cliente = cliente;
	}

	/*================= getters y setters =================*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DetalleFactura> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
	
	
	
}
