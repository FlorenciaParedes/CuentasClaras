package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column
	private String nombreUsuario; 
	 
	@Column(name = "nombre")
	 private String nombre;	
	
	@Column(name = "apellido")
    private String apellido;
	
	@Column(name = "email")
    private String email;
	
	@Column(name = "contrasena")
    private String contrasena;
	

	/*@ManyToMany // si dejo esta linea se me rompe en consola
	private List<Grupo> grupos = new ArrayList<>();
	
	*/
	@ManyToMany
    @JoinTable(
        name = "amigos",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "amigo_id")
    )
    private List<Usuario> amigos= new ArrayList<>();;
	
	//private List<Saldo> saldos; 

	/*Constructores*/

	public Usuario() {
	
	}
	
	public Usuario(String nombreUsuario, String nombre, String apellido, String email, String contrasena) {
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasena = contrasena;
	}
	
	
	/*geters y seters*/
	public long getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContraseña() {
		return contrasena;
	}

	public void setContraseña(String contrasena) {
		this.contrasena = contrasena;
	}

	/*
	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}*/
	
	
/*
	 public List<Saldo> getSaldos() {
		return saldos;
	}

	public void setSaldos(List<Saldo> saldos) {
		this.saldos = saldos;
	}
	
*/
	
/*
		
	public void registrarGasto(String nombre, Date fecha,byte imagen, CategoriaGasto categoria, List<Usuario> usuarios,double monto,Division division) {}
		// llama al constructor de gasto con un usuario en particular o con un grupo y lo guarda en la base
	public void registrarPago(Saldo saldo){}
		// llama al metodo de saldo que registra el pago.

	public List<Usuario> verAmigos(){
		return amigos;
	}
	
	public float calcularSaldoTotal() {
		//Calcula el saldo total.
		return 0;
	}
	public void iniciarSesion(String email,String contraseña) {}

	public void agregarAmigo(Usuario amigo) {}// agrega un usuario a la lista de amigos
	public void registrarSaldo(Saldo saldo) {} //agega a la lista de saldos

*/
	
	
	/*metodos*/
	public void agregarAmigo(Usuario amigo) {// agrega un usuario a la lista de amigos
		this.amigos.add(amigo);
		
	}

	
	
}
