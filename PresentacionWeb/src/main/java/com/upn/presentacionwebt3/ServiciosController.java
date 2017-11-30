package com.upn.presentacionwebt3;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import Pojo.Servicio;
import Utilidades.Constantes;

@Controller
public class ServiciosController {
	@RequestMapping(value = "/ListarServicios", method = RequestMethod.GET)
	public ModelAndView listar( HttpServletRequest req) {
		try {
			
			
			
			ModelAndView m = new ModelAndView("ListaServicios");
			String URI = Constantes.urlAPI + "/ListaServicio";
			RestTemplate rest = new RestTemplate();
			ArrayList<Servicio> lista = new ArrayList<Servicio>();
			ArrayList<Servicio> result = rest.getForObject(URI,lista.getClass());
			
			m.addObject("lista", result);
			return m;
		} catch (Exception e) {
			return new ModelAndView("frmError", "error", e.getMessage());
			 
		}
		
	}
	@RequestMapping(value = "/nuevoServicio", method = RequestMethod.GET)
	public ModelAndView nuevoServicio( HttpServletRequest req) {
		try {
			
			
			
			ModelAndView m = new ModelAndView("nuevoServicio");
			
			
			
			return m;
		} catch (Exception e) {
			return new ModelAndView("frmError", "error", e.getMessage());
			 
		}
		
	}
	@RequestMapping(value = "/editarServicio", method = RequestMethod.GET)
	public ModelAndView editarServicio( @RequestParam("idservicio")int idservicio,HttpServletRequest req) {
		try {
			
			
			
			ModelAndView m = new ModelAndView("editarServicio");
			
			
			
			String URI = Constantes.urlAPI + "/obtenerServicio?idservicio="+idservicio;
			RestTemplate rest = new RestTemplate();
			//servicio servicio=new Servicio();
			Servicio result = rest.getForObject(URI,Servicio.class);
			
			m.addObject("servicio", result);
			return m;
		} catch (Exception e) {
			return new ModelAndView("frmError", "error", e.getMessage());
			 
		}
		
	}
	@RequestMapping(value = "/insertarServicio", method = RequestMethod.GET)
	public String insertarServicio(@RequestParam("servicio")String servicio, HttpServletRequest req) {
		try {
			
			
			
			RestTemplate rest = new RestTemplate();
			
			
			
			
			String uri = Constantes.urlAPI + "/insertarServicio?descripcion="+servicio;			
			String result =  rest.getForObject(uri,String.class);
					
			if(result.equals("true")) {
				return "redirect:/ListarServicios";				
			}
			return "redirect:/frmError?msg=No se pudo insertar";
		} catch (Exception e) {
			return "redirect:/frmError?msg="+e.getMessage();
		}	
		
	}
	@RequestMapping(value = "/actualizarServicio", method = RequestMethod.GET)
	public String actualizarServicio(@RequestParam("idservicio")String idservicio,@RequestParam("servicio")String servicio, HttpServletRequest req) {
		try {
			
			
			
			RestTemplate rest = new RestTemplate();
			
			
			
			
			String uri = Constantes.urlAPI + "/actualizarServicio?idservicio="+idservicio+"&descripcion="+servicio;			
			String result =  rest.getForObject(uri,String.class);
					
			if(result.equals("true")) {
				return "redirect:/ListarServicios";				
			}
			return "redirect:/frmError?msg=No se pudo insertar";
		} catch (Exception e) {
			return "redirect:/frmError?msg="+e.getMessage();
		}	
		
	}
}
