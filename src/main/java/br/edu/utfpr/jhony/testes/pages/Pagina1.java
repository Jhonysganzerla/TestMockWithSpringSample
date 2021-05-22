package br.edu.utfpr.jhony.testes.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pagina1")

class Pagina1 {

	@GetMapping("")
	public String  Pagina1() {
		return "pagina1";
	}
}
