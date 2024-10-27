import java.util.*;

public class Piloto extends Persona {

	private Collection<Vuelo> vuelosInscritos;
	private String rutPiloto;
	private String idPiloto;

	public String getRutPiloto() {
		return this.rutPiloto;
	}

	/**
	 * 
	 * @param rutPiloto
	 */
	public void setRutPiloto(String rutPiloto) {
		this.rutPiloto = rutPiloto;
	}

	public String getIdPiloto() {
		return this.idPiloto;
	}

	/**
	 * 
	 * @param idPiloto
	 */
	public void setIdPiloto(String idPiloto) {
		this.idPiloto = idPiloto;
	}

}