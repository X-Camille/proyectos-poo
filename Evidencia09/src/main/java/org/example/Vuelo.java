import java.util.*;

public class Vuelo {

	private Avion avion;
	private Ciudad ciudadDestino;
	private Ciudad ciudadOrigen;
	private Collection<Pasajero> pasajeros;
	private Collection<Piloto> pilotos;
	private Date horaVuelo;

	public Date getHoraVuelo() {
		return this.horaVuelo;
	}

	/**
	 * 
	 * @param horaVuelo
	 */
	public void setHoraVuelo(Date horaVuelo) {
		this.horaVuelo = horaVuelo;
	}

}