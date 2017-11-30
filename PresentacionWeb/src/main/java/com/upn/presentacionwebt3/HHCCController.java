package com.upn.presentacionwebt3;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import Pojo.Historia;
import Utilidades.Constantes;

@Controller
public class HHCCController {
	@RequestMapping(value = "/ListarHistoria", method = RequestMethod.GET)
	public ModelAndView listar( HttpServletRequest req) {
		try {
			
						
			ModelAndView m = new ModelAndView("ListaHistoria");
			String URI = Constantes.urlAPI + "/ListaHistoria";
			RestTemplate rest = new RestTemplate();
			ArrayList<Historia> lista = new ArrayList<Historia>();
			ArrayList<Historia> result = rest.getForObject(URI,lista.getClass());
			
			m.addObject("lista", result);
		
			return m;
		} catch (Exception e) {
			return new ModelAndView("frmError", "error", e.getMessage());
			 
		}
		
	}
	@RequestMapping(value = "/nuevaHistoria", method = RequestMethod.GET)
	public ModelAndView nuevoServicio( HttpServletRequest req) {
		try {
			
			
			
			ModelAndView m = new ModelAndView("nuevaHistoria");
			
			
			
			return m;
		} catch (Exception e) {
			return new ModelAndView("frmError", "error", e.getMessage());
			 
		}
		
	}
	@RequestMapping(value = "/editarHistoria", method = RequestMethod.GET)
	public ModelAndView editarServicio( @RequestParam("idhistoria")int idHistoria,HttpServletRequest req) {
		try {
			
			
			
			ModelAndView m = new ModelAndView("editarHistoria");
			
			
			
			String URI = Constantes.urlAPI + "/obtenerHistoria?idhistoria="+idHistoria;
			RestTemplate rest = new RestTemplate();
			//servicio servicio=new Servicio();
			Historia result = rest.getForObject(URI,Historia.class);
			
			m.addObject("historia", result);
			return m;
		} catch (Exception e) {
			return new ModelAndView("frmError", "error", e.getMessage());
			 
		}
		
	}
	@RequestMapping(value = "/insertarHistoria", method = RequestMethod.GET)
	public String insertarServicio(@RequestParam("apepat")String apepat,
			@RequestParam("apemat")String apemat,
			@RequestParam("nombres")String nombres,
			@RequestParam("fechanac")String fechanac,
			@RequestParam("dni")String dni,
			@RequestParam("direccion")String direccion,
			
			HttpServletRequest req) {
		try {
			
			
			
			RestTemplate rest = new RestTemplate();
			
			
			
			
			String uri = Constantes.urlAPI + "/insertarHistoria?apepat="+apepat+
					"&apemat="+apemat+"&nombres="+nombres+"&fechanac="+fechanac+"&dni="+dni+
					"&direccion="+direccion;			
			String result =  rest.getForObject(uri,String.class);
					
			if(result.equals("true")) {
				return "redirect:/ListarHistoria";				
			}
			return "redirect:/frmError?msg=No se pudo insertar";
		} catch (Exception e) {
			return "redirect:/frmError?msg="+e.getMessage();
		}	
		
	}
	@RequestMapping(value = "/actualizarHistoria", method = RequestMethod.GET)
	public String actualizarServicio(@RequestParam("idhistoria")String idhistoria,
			@RequestParam("apepat")String apepat,
			@RequestParam("apemat")String apemat,
			@RequestParam("nombres")String nombres,
			@RequestParam("fechanac")String fechanac,
			@RequestParam("dni")String dni,
			@RequestParam("direccion")String direccion, HttpServletRequest req) {
		try {
			
			
			
			RestTemplate rest = new RestTemplate();
			
			
			
			
			String uri = Constantes.urlAPI + "/actualizarHistoria?idhistoria="+idhistoria+"&apepat="+apepat+
					"&apemat="+apemat+"&nombres="+nombres+"&fechanac="+fechanac+
					"&dni="+dni+"&direccion="+direccion;			
			String result =  rest.getForObject(uri,String.class);
					
			if(result.equals("true")) {
				return "redirect:/ListarHistoria";				
			}
			return "redirect:/frmError?msg=No se pudo insertar";
		} catch (Exception e) {
			return "redirect:/frmError?msg="+e.getMessage();
		}	
		
	}
}

