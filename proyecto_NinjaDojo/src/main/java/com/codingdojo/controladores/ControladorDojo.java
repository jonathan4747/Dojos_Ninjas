package com.codingdojo.controladores;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.modelos.Dojo;
import com.codingdojo.servicios.ServicioDojo;

@Controller
public class ControladorDojo {
	
	@Autowired
	ServicioDojo servicioDojo;
	
	@RequestMapping( value = "/dojos/new", method = RequestMethod.GET )
	public String PaginaDojo(@ModelAttribute("dojo") Dojo nuevoDojo) {
		return "dojo.jsp";
	}
	@RequestMapping( value = "/dojos/new", method = RequestMethod.POST )
	public String CreaDojo( @Valid @ModelAttribute("dojo") Dojo nuevoDojo, BindingResult result) {
		if(result.hasErrors()) {
			return "dojo.jsp";
		}
		else {
			servicioDojo.nuevoDojo(nuevoDojo);
			return "redirect:/dojos/new";
		}
	}
	@RequestMapping(value = "/dojos/{id}",method = RequestMethod.GET)
		public String Ver(@PathVariable("id") long id,HttpSession session,Model model) {
			Dojo dojo = servicioDojo.EncontrarId(id);
			session.setAttribute("nombre", dojo.getNombre());
			List<Object []> reglones = servicioDojo.listaNinja(id);
			model.addAttribute("reglones", reglones);
			return "show.jsp";
		}
	
	
	
}
