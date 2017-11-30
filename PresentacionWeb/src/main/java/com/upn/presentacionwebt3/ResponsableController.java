package com.upn.presentacionwebt3;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import Pojo.Responsable;
import Pojo.Servicio;
import Utilidades.Constantes;

@Controller
public class ResponsableController {
	@RequestMapping(value = "/ListarResponsables", method = RequestMethod.GET)
	public ModelAndView listar( HttpServletRequest req) {
		try {
			
						
			ModelAndView m = new ModelAndView("ListaResponsables");
			String URI = Constantes.urlAPI + "/ListaResponsable";
			RestTemplate rest = new RestTemplate();
			ArrayList<Responsable> lista = new ArrayList<Responsable>();
			ArrayList<Responsable> result = rest.getForObject(URI,lista.getClass());
			
			m.addObject("lista", result);
		
			return m;
		} catch (Exception e) {
			return new ModelAndView("frmError", "error", e.getMessage());
			 
		}
		
	}
	@RequestMapping(value = "/nuevoResponsable", method = RequestMethod.GET)
	public ModelAndView nuevoServicio( HttpServletRequest req) {
		try {
			
			
			
			ModelAndView m = new ModelAndView("nuevoResponsable");
			
			
			
			return m;
		} catch (Exception e) {
			return new ModelAndView("frmError", "error", e.getMessage());
			 
		}
		
	}
	@RequestMapping(value = "/editarResponsable", method = RequestMethod.GET)
	public ModelAndView editarServicio( @RequestParam("idresponsable")int idresponsable,HttpServletRequest req) {
		try {
			
			
			
			ModelAndView m = new ModelAndView("editarResponsable");
			
			
			
			String URI = Constantes.urlAPI + "/obtenerResponsable?idresponsable="+idresponsable;
			RestTemplate rest = new RestTemplate();
			//servicio servicio=new Servicio();
			Responsable result = rest.getForObject(URI,Responsable.class);
			
			m.addObject("responsable", result);
			return m;
		} catch (Exception e) {
			return new ModelAndView("frmError", "error", e.getMessage());
			 
		}
		
	}
	@RequestMapping(value = "/insertarResponsable", method = RequestMethod.GET)
	public String insertarServicio(@RequestParam("descripcion")String descripcion, HttpServletRequest req) {
		try {
			
			
			
			RestTemplate rest = new RestTemplate();
			
			
			
			
			String uri = Constantes.urlAPI + "/insertarResponsable?descripcion="+descripcion;			
			String result =  rest.getForObject(uri,String.class);
					
			if(result.equals("true")) {
				return "redirect:/ListarResponsables";				
			}
			return "redirect:/frmError?msg=No se pudo insertar";
		} catch (Exception e) {
			return "redirect:/frmError?msg="+e.getMessage();
		}	
		
	}
	@RequestMapping(value = "/actualizarResponsable", method = RequestMethod.GET)
	public String actualizarServicio(@RequestParam("idresponsable")String idresponsable,
			@RequestParam("descripcion")String descripcion, HttpServletRequest req) {
		try {
			
			
			
			RestTemplate rest = new RestTemplate();
			
			
			
			
			String uri = Constantes.urlAPI + "/actualizarResponsable?idresponsable="+idresponsable+"&descripcion="+descripcion;			
			String result =  rest.getForObject(uri,String.class);
					
			if(result.equals("true")) {
				return "redirect:/ListarResponsables";				
			}
			return "redirect:/frmError?msg=No se pudo insertar";
		} catch (Exception e) {
			return "redirect:/frmError?msg="+e.getMessage();
		}	
		
	}
}
