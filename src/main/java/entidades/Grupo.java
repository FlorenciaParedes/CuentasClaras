package entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="grupo")
public class Grupo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nombre")
    private String nombre;
	
	@Column(name = "imagen")
    private byte imagen;
	
	//private CategoriaGrupo categoria; 
	
	//private List<Gasto> gastos; 
	@ManyToMany(mappedBy = "grupos")
	private List<Usuario> integrantes;
	
    public Grupo( String nombre, byte imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }
	
	public long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/*
	public CategoriaGrupo getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaGrupo categoria) {
		this.categoria = categoria;
	}*/
	public byte getImagen() {
		return imagen;
	}

	public void setImagen(byte imagen) {
		this.imagen = imagen;
	}
	
	
	
	//metodos
	public Grupo  altaGrupo (String nombre, List<Usuario> integrantes, CategoriaGrupo categoria) {
		return null;
	}
	
	public void agregarIntegrante(Usuario usuario) {
		
	}
	
	public Gasto cargarGasto(Gasto gasto) {
		return null;
	}
	/*
	public List<Usuario> verIntegrantes() {
		return integrantes;
	}
	public List<Gasto> verGastos() {
		return gastos;
	}
*/

}
