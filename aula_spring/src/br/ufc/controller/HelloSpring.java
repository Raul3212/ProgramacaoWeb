package br.ufc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloSpring {

	@RequestMapping("/helloSpring")
	public String helloSpring(){
		return "hello_ok"; //Spring vai redirecionar para a página /WEB-INF/views/hello_ok.jsp
	}
	
}
