package br.com.ifpe.rhcontrolmail.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import br.com.ifpe.rhcontrolmail.model.MailDTO;
import br.com.ifpe.rhcontrolmail.model.Pagamento;
import br.com.ifpe.rhcontrolmail.service.MailService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class StringConsumerListener {

    public static final String SEND_MAIL = "enviar-email";

    @Autowired
    private MailService mailService;
    
    @KafkaListener(groupId = "group-1", topics = SEND_MAIL, containerFactory = "strContainerFactory")
    public void listener(String message) throws Exception {
    	ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    	Pagamento pagamento = objectMapper.readValue(message, Pagamento.class);
    	MailDTO mailDTO = new MailDTO(pagamento);
    	
    	mailService.sendMail(mailDTO);
    }

}

