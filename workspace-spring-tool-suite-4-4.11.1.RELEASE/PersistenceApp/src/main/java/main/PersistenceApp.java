package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Articulo;
import entidades.Categoria;
import entidades.Cliente;
import entidades.DetalleFactura;
import entidades.Domicilio;
import entidades.Factura;

public class PersistenceApp {

	public static void main (String []args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceAppPU");
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			
			Factura factura1 = new Factura();
			factura1.setNumero(12);
			factura1.setFecha("10/08/2020");
			
			Domicilio dom = new Domicilio("Bernardo Houssay", 682);
			Cliente cliente = new Cliente ("Paulina", "Sosa", 41418234);
			
			cliente.setDomicilio(dom);
			
			factura1.setCliente(cliente);
			
			Categoria perecederos = new Categoria("perecederos");
			Categoria lacteos = new Categoria("Lacteos");
			Categoria limpieza = new Categoria("Limpieza");
			
			Articulo art1 = new Articulo(200, "yogurt", 20);
			Articulo art2 = new Articulo(300, "detergente", 80);
			
			art1.getCategorias().add(perecederos);
			art1.getCategorias().add(lacteos);
			
			art2.getCategorias().add(limpieza);
			
			DetalleFactura detalle1= new DetalleFactura();
			
			detalle1.setArticulo(art1);
			detalle1.setCantidad(2);
			detalle1.setSubtotal(40);
			
			factura1.getDetalles().add(detalle1);
			
			DetalleFactura detalle2 = new DetalleFactura();
			
			detalle2.setArticulo(art2);
			detalle2.setCantidad(1);
			detalle2.setSubtotal(80);
			
			factura1.getDetalles().add(detalle2);
			
			factura1.setTotal(120);
			
			em.persist(factura1);
			
			em.flush();
			em.getTransaction().commit();
			
		}catch(Exception e) {
			
			em.getTransaction().rollback();
		}
		
		
		em.close();
		emf.close();
	}
}