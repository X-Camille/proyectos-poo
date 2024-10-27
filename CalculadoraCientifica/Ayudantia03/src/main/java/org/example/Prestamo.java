public class Prestamo {

	private Usuario usuarios;
	private Bibliotecario Bibliotecario;
	private Bibliotecario bibliotecario;
	private Usuario usuario;
	private Libro Libro;
	private String fecha_inicio;
	private String fecha_termino;

	public Bibliotecario getBibliotecario() {
		return this.bibliotecario;
	}

	/**
	 * 
	 * @param bibliotecario
	 */
	public void setBibliotecario(Bibliotecario bibliotecario) {
		this.bibliotecario = bibliotecario;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	/**
	 * 
	 * @param usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getLibro() {
		// TODO - implement Prestamo.getLibro
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param libro
	 */
	public void setLibro(String libro) {
		// TODO - implement Prestamo.setLibro
		throw new UnsupportedOperationException();
	}

	public String getFecha_inicio() {
		return this.fecha_inicio;
	}

	/**
	 * 
	 * @param fecha_inicio
	 */
	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getFecha_termino() {
		return this.fecha_termino;
	}

	/**
	 * 
	 * @param fecha_termino
	 */
	public void setFecha_termino(String fecha_termino) {
		this.fecha_termino = fecha_termino;
	}

	public Prestamo() {
		// TODO - implement Prestamo.Prestamo
		throw new UnsupportedOperationException();
	}

}