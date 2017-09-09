package Middleware;

import java.io.Serializable;

public interface ITiempoDerivaSerializable extends Serializable {
	public long getDeriva();
	public void setDeriva(long deriva);
	public String getFecha();
	public void setFecha(String fecha);
}
