package cat.itacademy.barcelonactiva.lopezriba.carlos.s05.t01.n01.model.dto;

import java.util.ArrayList;
import java.util.List;

public class SucursalDTO {

	private long pk_SucursalID;
	String nomSucursal;
	String paisSucursal;
	String tipusSucursal;
	private List<String> paisosUE = new ArrayList<>();

	public SucursalDTO() {
		
	}
	

	public SucursalDTO(String nomSucursal, String paisSucursal, long pk_SucursalID) {
		paisosUE.add("España");
		paisosUE.add("Francia");
		paisosUE.add("Alemania");
		paisosUE.add("Italia");
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
		this.pk_SucursalID = pk_SucursalID;
		
		if (paisosUE.contains(paisSucursal)) {
			tipusSucursal = "UE";
		}
		else {
			tipusSucursal = "Fora UE";
		}
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
		
		if (paisosUE.contains(paisSucursal)) {
			tipusSucursal = "UE";
		}
		else {
			tipusSucursal = "Fora UE";
		}
	}


	public String getTipusSucursal() {
		return tipusSucursal;
	}
	
	
}
