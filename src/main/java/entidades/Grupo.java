package entidades;

import java.util.List;

public class Grupo {
	private long id;
	private String nombre; 
	private CategoriaGrupo categoria; 
	private List<Gasto> gastos; 
	private List<Usuario> integrantes;
	private Imagen imagen;
		
	public long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CategoriaGrupo getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaGrupo categoria) {
		this.categoria = categoria;
	}
	public Imagen getImagen() {
		return imagen;
	}

	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}
	//metodos
	public void altaGrupo (String nombre, List<Usuario> integrantes) {
		
	}
	
	public void agregarMiembro(Usuario usuario) {
		
	}
	
	public void cargarGasto(Gasto gasto) {
		
	}
	public List<Usuario> verMiembros() {
		return integrantes;
	}
	public List<Gasto> verGastos() {
		return gastos;
	}


}
