package com.codingdojo.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.modelos.Dojo;
import com.codingdojo.modelos.Ninja;
import com.codingdojo.servicios.ServicioDojo;
import com.codingdojo.servicios.ServicioNinja;

@Controller
public class ControladorNinja {
	@Autowired
	ServicioNinja servicioNinja;
	@Autowired
	ServicioDojo servicioDojo;
	
	@RequestMapping( value = "/ninjas/new", method = RequestMethod.GET )
	public String paginaNinja(@ModelAttribute("ninja") Ninja nuevoNinja,Model model) {
		List<Dojo> lista = servicioDojo.DespliegaDojo();
		model.addAttribute("dojos", lista);
		return "ninja.jsp";
	
	}
	
	@RequestMapping( value = "/ninjas/new", method = RequestMethod.POST)
	public String CrearNinja(@Valid @ModelAttribute("ninja") Ninja nuevoNinja, BindingResult result,Model model) {
		if(result.hasErrors()) {
			List<Dojo> lista = servicioDojo.DespliegaDojo();
			model.addAttribute("dojos", lista);
			return "ninja.jsp";
		}
		else {
			servicioNinja.CreateNinja(nuevoNinja);
			return "redirect:/ninjas/new";
		}
	}
	
	
}
