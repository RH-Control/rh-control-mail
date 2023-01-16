package br.com.ifpe.rhcontrolmail.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class MailDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "The sender is required for sending email")
	@Email
	private String from = "rh.control.mail@gmail.com";

	@NotBlank(message = "Recipient is required for sending email")
	@Email
	private String to;

	@NotBlank(message = "The subject is required for sending email")
	private String subject;

	@NotBlank(message = "Template .html is required for sending email")
	private String template;

	Map<String, Object> properties;

	public MailDTO() {
	}
	
	public MailDTO(Pagamento pagamento) {
		this.to = pagamento.getFuncionario().getEmail();
		String competencia = pagamento.getCompetencia().toString().substring(0, pagamento.getCompetencia().toString().length()-3);
		this.subject = "Contracheque " + competencia;
		this.template = "contracheque.html";
		this.properties =  this.buildProperties(pagamento, competencia);
	}

	private Map<String, Object> buildProperties(Pagamento pagamento, String competencia) {
		Map<String, Object> properties = new HashMap<>();
		properties.put("nomeSocial", pagamento.getFuncionario().getNomeSocial());
		properties.put("competencia", competencia);
		properties.put("totalDeHoras", pagamento.getTotalDeHoras());
		properties.put("horaSalario", pagamento.getFuncionario().getCargo().getHoraSalario());
		properties.put("valorTotal", pagamento.getValor());
		return properties;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}
}
