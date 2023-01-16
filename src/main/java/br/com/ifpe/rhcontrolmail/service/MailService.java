package br.com.ifpe.rhcontrolmail.service;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import br.com.ifpe.rhcontrolmail.model.MailDTO;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailService{

	private static Logger LOGGER = LoggerFactory.getLogger(MailService.class);
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private SpringTemplateEngine springTemplateEngine;
	
	public MailService(JavaMailSender mailSender, SpringTemplateEngine springTemplateEngine) {
		this.mailSender = mailSender;
		this.springTemplateEngine = springTemplateEngine;
	}
	
	public void sendMail(MailDTO mailDTO) throws Exception {
		try {
			
			mailDTO.getProperties().put("currentYear", LocalDateTime.now().getYear());
			
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			Context context = new Context();

			context.setVariables(mailDTO.getProperties());
			helper.setFrom(mailDTO.getFrom());
			helper.setTo(mailDTO.getTo());
			helper.setSubject(mailDTO.getSubject());

			String html = springTemplateEngine.process(mailDTO.getTemplate(), context);
			helper.setText(html, true);

			mailSender.send(message);
			LOGGER.info("E-mail enviado com sucesso!");
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

}
