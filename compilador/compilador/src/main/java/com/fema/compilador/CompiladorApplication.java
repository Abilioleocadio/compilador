package com.fema.compilador;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

/**
 * @author Abílio
 *	Method from Started aplication
 * 	Comand: ALT, SHIFT, x + j
 * 	Debug:  ALT, SHIFT, d + j
 */
@SpringBootApplication
public class CompiladorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompiladorApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localeResolver(){
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}
}
