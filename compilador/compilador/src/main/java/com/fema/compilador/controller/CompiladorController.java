package com.fema.compilador.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fema.compilador.service.IntegradorService;

@Controller
@RequestMapping("/compilador")
public class CompiladorController {

	@Autowired private IntegradorService integradorService;
	
	public String responseSave;
	
	@GetMapping()
	public ModelAndView listar(){
		ModelAndView modelAndView = new ModelAndView("compilador/compilador.html");
		return modelAndView;
	}
	
	@RequestMapping(value= "/request")
	public @ResponseBody String lexico(@RequestParam(value = "linguagem", required = false) String linguagem) throws IOException{
		String response = integradorService.integradorLexico(linguagem);
		System.out.println(response);
		responseSave = response;
		return response;
	}
	
	@RequestMapping(value="/lexico")
	public ModelAndView resposta(){
		ModelAndView modelAndView = new ModelAndView("compilador/lexico.html");
		if(responseSave != null){
			if(responseSave.contains(" - Valor inválido")){
				modelAndView.addObject("error", "error");
			}
		}
		modelAndView.addObject("response", responseSave);
		return modelAndView;
	}

	public String getResponseSave() {
		return responseSave;
	}

	public void setResponseSave(String responseSave) {
		this.responseSave = responseSave;
	}
	
}
