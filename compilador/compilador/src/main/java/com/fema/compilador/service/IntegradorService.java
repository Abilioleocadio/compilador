package com.fema.compilador.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fema.compilador.lexico.LanguageSextaFase;

@Service
public class IntegradorService {

	public String integradorLexico(String file) throws IOException{
		String response = LanguageSextaFase.analisador(file.toString());
		
		return response;
	}
	
}
