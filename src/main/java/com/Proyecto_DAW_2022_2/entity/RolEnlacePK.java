package com.Proyecto_DAW_2022_2.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class RolEnlacePK implements Serializable{
	private int idRol;
	private int idEnlace;
	@Override
	public int hashCode() {
		return Objects.hash(idEnlace, idRol);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolEnlacePK other = (RolEnlacePK) obj;
		return idEnlace == other.idEnlace && idRol == other.idRol;
	}
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public int getIdEnlace() {
		return idEnlace;
	}
	public void setIdEnlace(int idEnlace) {
		this.idEnlace = idEnlace;
	}
}
