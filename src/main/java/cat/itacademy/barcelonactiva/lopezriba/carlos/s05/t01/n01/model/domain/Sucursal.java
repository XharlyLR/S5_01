package cat.itacademy.barcelonactiva.lopezriba.carlos.s05.t01.n01.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sucursal")
public class Sucursal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pk_SucursalID;
	
	@Column(name = "nom_sucursal")
	String nomSucursal;
	
	@Column(name = "pais_sucursal")
	String paisSucursal;
	
	public Sucursal() { }
	
	public Sucursal(String nomSucursal, String paisSucursal) {
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
	}

	public long getPk_SucursalID() {
		return pk_SucursalID;
	}
	
	public void setPk_SucursalID(long pk_SucursalID) {
		this.pk_SucursalID = pk_SucursalID;
	}
	
	public String getNomSucursal() {
		return nomSucursal;
	}

	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}

	public String getPaisSucursal() {
		return paisSucursal;
	}

	public void setPaisSucursal(String paisSucursal) {
		this.paisSucursal = paisSucursal;
	}

	@Override
	public String toString() {
		return "Sucursal [pk_SucursalID=" + pk_SucursalID + ", nomSucursal=" + nomSucursal + ", paisSucursal="
				+ paisSucursal + "]";
	}
	
}
