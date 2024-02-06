package ec.edu.ups.ppw67.demo68.transferencia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Operadora {
	@Id
	@GeneratedValue
	private int codigo;
	private String Nombre;
	private double saldo;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	@Override
	public String toString() {
		return "operadora [codigo=" + codigo + ", Nombre=" + Nombre + ", saldo=" + saldo + "]";
	}
}
