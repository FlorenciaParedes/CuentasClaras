package entidades;

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
	

//	private List<Usuario> amigos;
	
	@ManyToMany
	@JoinTable(
		name = "usuario_grupo", // Nombre de la tabla intermedia
		joinColumns = @JoinColumn(name = "usuario_id"), // Define el campo (columna) en la tabla intermedia que se utilizará como clave externa para la entidad Usuario
	    inverseJoinColumns = @JoinColumn(name = "grupo_id") // Define el campo (columba) en la tabla intermedia que se utilizará como clave externa para la entidad Grupo
		)
	private List<Grupo> grupos;
	//private List<Saldo> saldos; 

	
	//geters y seters
	public long getId() {
		return id;
	}

	public Usuario() {
	
	}
	
	public Usuario(String nombreUsuario, String nombre, String apellido, String email, String contrasena) {
	    this.nombreUsuario = nombreUsuario;
	    this.nombre = nombre;
	    this.apellido = apellido;
	    this.email = email;
	    this.contrasena = contrasena;
	    //this.grupos.add(grupo);
	}
	
	public Usuario(String nombreUsuario) {
	    super();
	    this.nombreUsuario = nombreUsuario;
	}
	
    public Usuario(long id, String nombreUsuario) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		
	}

/*	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
*/
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/*public String getApellido() {
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
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public List<Saldo> getSaldos() {
		return saldos;
	}

	public void setSaldos(List<Saldo> saldos) {
		this.saldos = saldos;
	}
	


	// metodos
	
	public void altaUsuario(String nombreUsuario,String nombre, String apellido, String email,String contraseña) {}
		// Da de alta un usuario 
	public void registrarGrupo (String nombre, List<Usuario> usuarios, CategoriaGrupo categoria) {}
		// llama al constructor de grupo y lo guarda en la base
	public void registrarGasto(String nombre, Date fecha,byte imagen, CategoriaGasto categoria, List<Usuario> usuarios,double monto,Division division) {}
		// llama al constructor de gasto con un usuario en particular o con un grupo y lo guarda en la base
	public void registrarPago(Saldo saldo){}
		// llama al metodo de saldo que registra el pago.
	public void invitarUsuarioAGrupo(Grupo grupo,Usuario usuario){}
		// llama al metodo de grupo que agega un usuario a la lista de integrantes
	public List<Grupo> verGrupos(){ 
		return grupos;
	}

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
	
	
	
}
