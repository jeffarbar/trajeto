package br.com.send.trajeto.vo;

import org.springframework.beans.BeanUtils;

import br.com.send.trajeto.model.TrajetoModel;
import br.com.send.trajeto.util.DataUtil;

public class TrajetoVo {

	
	public TrajetoVo(TrajetoModel trafegoModel) {
		if(trafegoModel != null) {
			BeanUtils.copyProperties(trafegoModel , this);
			this.setDtCriacao(DataUtil.converteData(trafegoModel.getDtCriacao()));
		}
	}
	
	private String id;
	 
	private String dtCriacao;
	 
	private String identificadorDispositivo;
	 
	private Double latitude;
	 
	private Double longitude;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(String dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public String getIdentificadorDispositivo() {
		return identificadorDispositivo;
	}

	public void setIdentificadorDispositivo(String identificadorDispositivo) {
		this.identificadorDispositivo = identificadorDispositivo;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
}
