package xovr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

import xovr.models.web.ui.InDbMessageRepository;
//import xovr.models.web.ui.InMemoryMessageRepository;
import xovr.models.web.ui.Message;
import xovr.models.web.ui.MessageRepository;

@SpringBootApplication
public class Application {
	
	@Bean
	public MessageRepository messageRepository() {
		//return new InMemoryMessageRepository();
		return new InDbMessageRepository();
	}

	@Bean
	public Converter<String, Message> messageConverter() {
		return new Converter<String, Message>() {
			@Override
			public Message convert(String id) {
				return messageRepository().findMessage(Long.valueOf(id));
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
