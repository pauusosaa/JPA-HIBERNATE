package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;


@Entity
@Table(name="categoria")
@Audited
public class Categoria implements Serializable {

	/*================= atributos =================*/
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "denominacion")
	private String denominacion;
	
	/*================= constructores =================*/
	

	public Categoria() {
		
	}
	
	public Categoria(String denominacion) {
		
		this.denominacion = denominacion;
	}

	/*================= getters y setters =================*/
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	
	
	
}
