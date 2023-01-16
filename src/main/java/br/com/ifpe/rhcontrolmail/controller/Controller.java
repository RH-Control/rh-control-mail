package br.com.ifpe.rhcontrolmail.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.ifpe.rhcontrolmail.model.MailDTO;
import br.com.ifpe.rhcontrolmail.service.MailService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/mail")
public class Controller {

	private MailService mailService;

	public Controller(MailService mailService) {
		this.mailService = mailService;
	}

	@PostMapping("/send")
	public ResponseEntity<MailDTO> send(@Valid @RequestBody MailDTO mailDTO) throws Exception {
		try {
			this.mailService.sendMail(mailDTO);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

}