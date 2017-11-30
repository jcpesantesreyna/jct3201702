package com.upn.presentacionwebt3;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import Pojo.Usuario;
import Utilidades.Constantes;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)	
	public ModelAndView home(Locale locale, Model model) {
			
			return new ModelAndView("home", "command", new Usuario());
		}
		@RequestMapping(value = "/VerificarAcceso", method = RequestMethod.POST)
		public String VerificarAcceso(@ModelAttribute("SpringWeb")Usuario u, 
							HttpServletRequest req, ModelMap model) {		
			try {
				String Sesion = u.getSesion();
				String Password = u.getPassword();
				//Verficamos acceso desde la API REST
				RestTemplate rest = new RestTemplate();
				String URI = 
					Constantes.urlAPI+ "/login?sesion="+Sesion+"&password="+ Password;
				Usuario result = rest.getForObject(URI, u.getClass());
				if(result!=null) {
					//agregamos el usuario logueado a la sesion 
					req.getSession().setAttribute("usuario", result);
					
					return "frmMenuPrincipal";				
				}else {
					return "redirect:/?msg=Usuario o password no valido";
				}			
			} catch (Exception e) {
				return "frmError";
			}
	
}
}
