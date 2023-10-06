package entidades;

import java.util.Date;
import java.util.List;

public class Usuario {
	private long id;
	private String nombre; 
	private String nombreUsuario; 
	private String apellido; 
	private String email;
	private String contraseña;
	
	private List<Usuario> amigos;
	private List<Grupo> grupos;
	private List<Saldo> saldos; 
	private List<Gasto> gastos; 

	
	//geters y seters
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
	
	public List<Gasto> getGastos() {
		return gastos;
	}

	public void setGastos(List<Gasto> gastos) {
		this.gastos = gastos;
	}


	// metodos
	
	public void altaUsuario(String nombreUsuario,String nombre, String apellido, String email,String contraseña) {}
		// Da de alta un usuario 
	public void registrarGrupo (String nombre, List<Usuario> usuarios, CategoriaGrupo categoria) {}
		// llama al constructor de grupo y lo guarda en la base
	public void registrarGasto(String nombre, Date fecha,Imagen imagen, CategoriaGasto categoria, List<Usuario> usuarios,double monto,Division division) {}
		// llama al constructor de gasto con un usuario en particular o con un grupo y lo guarda en la base
	public void realizarPago(Saldo saldo){}
		// llama al metodo de saldo que registra el pago.
	public void invitarUsuarioAGrupo(Grupo grupo,Usuario usuario){}
		// llama al metodo de grupo que agega un usuario a la lista de integrantes
	public List<Grupo> verGrupos(){ 
		return grupos;
	}

	public List<Usuario> verAmigos(){
		return amigos;
	}
	
	public float verSaldoTotal() {
		//Calcula el saldo total.
		return 0;
	}



}
