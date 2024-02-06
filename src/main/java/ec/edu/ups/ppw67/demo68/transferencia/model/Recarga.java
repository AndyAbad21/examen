package ec.edu.ups.ppw67.demo68.transferencia.model;

public class Recarga {
	private int idTelefono;
	private int idOperadora;
	private float monto;
	public int getidTelefono() {
		return idTelefono;
	}
	public void setidTelefono(int idTelefono) {
		this.idTelefono = idTelefono;
	}
	public int getIdoperadora() {
		return idOperadora;
	}
	public void setIdoperadora(int idoperadora) {
		this.idOperadora = idoperadora;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	@Override
	public String toString() {
		return "recarga [idTelefono=" + idTelefono + ", idoperadora=" + idOperadora + ", monto=" + monto + "]";
	}
	
	
}
