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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity
@Table (name ="articulo")
@Audited
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class Articulo implements Serializable{
	
	/*================= atributos =================*/
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column (name ="cantidad")
	@NonNull private int cantidad;
	
	@Column(name="denominacion")
	@NonNull private String denominacion;
	 
	@Column(name="precio")
	@NonNull private int precio;
	
	/*================= relaciones =================*/
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
				name = "articulo_categoria",
				joinColumns = @JoinColumn(name="articulo_id"),
				inverseJoinColumns = @JoinColumn(name = "categoria_id")
				)
	private List<Categoria> categorias = new ArrayList<Categoria>();
	
	
}
