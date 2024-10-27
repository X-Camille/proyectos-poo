public class PasaporteSanitario {

	private Pasajero pasajero;
	private String idPasaporte;
	private Date fechaPasaporte;
	private boolean resultadoPCR;
	private Date fechaResultado;

	public String getIdPasaporte() {
		return this.idPasaporte;
	}

	public Date getFechaPasaporte() {
		return this.fechaPasaporte;
	}

	public boolean getResultadoPCR() {
		return this.resultadoPCR;
	}

	public Date getFechaResultado() {
		return this.fechaResultado;
	}

}