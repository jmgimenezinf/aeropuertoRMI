package Middleware;

public class TiempoDeriva implements ITiempoDerivaSerializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long deriva;
	private String fecha;
	@Override
	public long getDeriva() {
		return this.deriva;
	}

	@Override
	public void setDeriva(long deriva) {
		this.deriva = deriva;
	}

	@Override
	public String getFecha() {
		return this.fecha;
	}

	@Override
	public void setFecha(String fecha) {
		this.fecha= fecha;
	}

}
