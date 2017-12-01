package com.upn.presentacionwebt3;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import Pojo.Programacion;
import Pojo.Servicio;
import Utilidades.Constantes;

@Controller
public class ProgramacionController {

	@RequestMapping(value = "/ListarProgramacion", method = RequestMethod.GET)
	public ModelAndView listar( HttpServletRequest req) {
		try {
			
						
			ModelAndView m = new ModelAndView("ListarProgramacion");
			String URI = Constantes.urlAPI + "/ListaProgramacion2";
			RestTemplate rest = new RestTemplate();
			ArrayList<Programacion> lista = new ArrayList<Programacion>();
			ArrayList<Programacion> result = rest.getForObject(URI,lista.getClass());
			
			m.addObject("lista", result);
		
			return m;
		} catch (Exception e) {
			return new ModelAndView("frmError", "error", e.getMessage());
			 
		}
		
	}
	@RequestMapping(value = "/nuevaProgramacion", method = RequestMethod.GET)
	public ModelAndView nuevoServicio( HttpServletRequest req) {
		try {
			String URI;
				ModelAndView m = new ModelAndView("nuevaProgramacion");
					URI = Constantes.urlAPI + "/ListaServicio";
					RestTemplate rest = new RestTemplate();
			ArrayList<Servicio> lista2 = new ArrayList<Servicio>();
			ArrayList<Servicio> result2 = rest.getForObject(URI,lista2.getClass());
			m.addObject("listaservicios", result2);
			
				URI = Constantes.urlAPI + "/ListaResponsable";
			
			ArrayList<Servicio> lista3 = new ArrayList<Servicio>();
			ArrayList<Servicio> result3 = rest.getForObject(URI,lista3.getClass());
			m.addObject("listaresponsables", result3);
			
		
			
			
			
			return m;
		} catch (Exception e) {
			return new ModelAndView("frmError", "error", e.getMessage());
			 
		}
		
	}
	@RequestMapping(value = "/editarProgramacion", method = RequestMethod.GET)
	public ModelAndView editarServicio( @RequestParam("idprogramacion")int idProgramacion,HttpServletRequest req) {
		try {
			
			
			
			ModelAndView m = new ModelAndView("editarProgramacion");
			
			
			
			String URI = Constantes.urlAPI + "/obtenerProgramacion?idprogramacion="+idProgramacion;
			RestTemplate rest = new RestTemplate();
			//servicio servicio=new Servicio();
			Programacion result = rest.getForObject(URI,Programacion.class);
			
			m.addObject("programacion", result);
			
			
			URI = Constantes.urlAPI + "/ListaServicio";
			
			ArrayList<Servicio> lista2 = new ArrayList<Servicio>();
			ArrayList<Servicio> result2 = rest.getForObject(URI,lista2.getClass());
			m.addObject("listaservicios", result2);
			
				URI = Constantes.urlAPI + "/ListaResponsable";
			
			ArrayList<Servicio> lista3 = new ArrayList<Servicio>();
			ArrayList<Servicio> result3 = rest.getForObject(URI,lista3.getClass());
			m.addObject("listaresponsables", result3);
			return m;
		} catch (Exception e) {
			return new ModelAndView("frmError", "error", e.getMessage());
			 
		}
		
	}
	@RequestMapping(value = "/insertarProgramacion", method = RequestMethod.GET)
	public String insertarServicio(@RequestParam("idservicio")	int idservicio,
			@RequestParam("idresponsable")	int idresponsable ,
			@RequestParam("turno")	String turno,
			@RequestParam("dialun")	int dialun,
			@RequestParam("diamar")	int diamar,
			@RequestParam("diamie")	int diamie,
			@RequestParam("diajue")	int diajue,
			@RequestParam("diavie")	int diavie,
			@RequestParam("diasab")	int diasab,
			@RequestParam("estado")	boolean estado,
			
			HttpServletRequest req) {
		try {
			
			
			
			RestTemplate rest = new RestTemplate();
			
			
			
			
			String uri = Constantes.urlAPI + "/insertarProgramacion?"
					+ "idservicio="+idservicio+"&idresponsable="+idresponsable+"&turno="+turno+"&dialun="+dialun+ 
		"&diamar="+diamar+"&diamie="+diamie+"&diajue="+diajue+"&diavie="+diavie+"&diasab="+diasab+"&estado="+estado;	
			String result =  rest.getForObject(uri,String.class);
			if(result.equals("true")) {
				return "redirect:/ListarProgramacion";				
			}
			return "redirect:/frmError?msg=No se pudo insertar";
		} catch (Exception e) {
			return "redirect:/frmError?msg="+e.getMessage();
		}	
		
	}
	@RequestMapping(value = "/actualizarProgramacion", method = RequestMethod.GET)
	public String actualizarServicio(@RequestParam("idprogramacion")String idprogramacion,
			@RequestParam("idservicio")int idservicio,
			@RequestParam("idresponsable")int idresponsable,
			@RequestParam("turno")String turno,
			@RequestParam("dialun")int dialun,
			@RequestParam("diamar")int diamar,
			@RequestParam("diamie")int diamie,
			@RequestParam("diajue")int diajue,
			@RequestParam("diavie")int diavie,
			@RequestParam("diasab")int diasab,
			@RequestParam("estado")boolean estado, HttpServletRequest req) {
		try {
			
			
			
			RestTemplate rest = new RestTemplate();
			
			
		
			
			String uri = Constantes.urlAPI + "/actualizarProgramacion?idprogramacion="+idprogramacion+"&idservicio="+idservicio+
					"&idresponsable="+idresponsable+"&turno="+turno+"&dialun="+dialun+
					"&diamar="+diamar+"&diamie="+diamie+"&diajue="+diajue+"&diavie="+diavie+
					"&diasab="+diasab+"&estado="+estado;			
			String result =  rest.getForObject(uri,String.class);
					
			if(result.equals("true")) {
				return "redirect:/ListarProgramacion";				
			}
			return "redirect:/frmError?msg=No se pudo insertar";
		} catch (Exception e) {
			return "redirect:/frmError?msg="+e.getMessage();
		}	
		
	}
}

