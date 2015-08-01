package org.upiicsa.presupuestos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Menu {

	@RequestMapping(value = "/Menu", method = RequestMethod.GET)
	public String getIndex(){
		return "Menu/index";
	}
}
