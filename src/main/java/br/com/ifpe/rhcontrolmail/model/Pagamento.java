package br.com.ifpe.rhcontrolmail.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Pagamento {

	private Long codigoPagamento;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate competencia;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataDePagamento;
	
	private BigDecimal valor;
	
	private Funcionario funcionario;
	
	private BigDecimal totalDeHoras;

	public Pagamento() {
	}
	
	public Pagamento(Long codigoPagamento, LocalDate competencia, LocalDate dataDePagamento, BigDecimal valor,
			Funcionario funcionario, BigDecimal totalDeHoras) {
		this.codigoPagamento = codigoPagamento;
		this.competencia = competencia;
		this.dataDePagamento = dataDePagamento;
		this.valor = valor;
		this.funcionario = funcionario;
		this.totalDeHoras = totalDeHoras;
	}
	
	public Long getCodigoPagamento() {
		return codigoPagamento;
	}

	public void setCodigoPagamento(Long codigoPagamento) {
		this.codigoPagamento = codigoPagamento;
	}

	public LocalDate getCompetencia() {
		return competencia;
	}

	public void setCompetencia(LocalDate competencia) {
		this.competencia = competencia;
	}

	public LocalDate getDataDePagamento() {
		return dataDePagamento;
	}

	public void setDataDePagamento(LocalDate dataDePagamento) {
		this.dataDePagamento = dataDePagamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public BigDecimal getTotalDeHoras() {
		return totalDeHoras;
	}

	public void setTotalDeHoras(BigDecimal totalDeHoras) {
		this.totalDeHoras = totalDeHoras;
	}

}
