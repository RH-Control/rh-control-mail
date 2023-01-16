package br.com.ifpe.rhcontrolmail.model;

import java.math.BigDecimal;

public class Cargo {

	private Long codigoCargo;
    private String nome;
    private BigDecimal horaSalario;
    
    public Cargo() {
	}
    
	public Cargo(Long codigoCargo, String nome, BigDecimal horaSalario) {
		this.codigoCargo = codigoCargo;
		this.nome = nome;
		this.horaSalario = horaSalario;
	}

	public Long getCodigoCargo() {
		return codigoCargo;
	}

	public void setCodigoCargo(Long codigoCargo) {
		this.codigoCargo = codigoCargo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getHoraSalario() {
		return horaSalario;
	}

	public void setHoraSalario(BigDecimal horaSalario) {
		this.horaSalario = horaSalario;
	}
    
    
}
