package com.upn.jct3;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Comun.LogicaResponsable;
import Entidades.Responsable;

@Controller
public class ResponsableController {
	@RequestMapping(value = "/insertarResponsable", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody boolean insertarResponsable(@RequestParam("descripcion")String descripcion,HttpServletRequest req) {
		boolean Responsable=false;
		
		try
		{
			Responsable=LogicaResponsable.Instancia().Insertar(descripcion)		;				
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Responsable;
		
		
	}
	@RequestMapping(value = "/actualizarResponsable", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody boolean actualizarResponsable(@RequestParam("descripcion")String descripcion,@RequestParam("idresponsable")
	int idresponsable,HttpServletRequest req) {
		boolean Responsable=false;
		
		try
		{
			Responsable=LogicaResponsable.Instancia().actualizar(idresponsable,descripcion);				
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Responsable;
		
		
	}
	@RequestMapping(value = "/obtenerResponsable", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody Responsable obtenerResponsable(@RequestParam("idresponsable")int idresponsable,HttpServletRequest req) {
		Responsable Responsable=null;
		
		try
		{
			Responsable=LogicaResponsable.Instancia().obtener(idresponsable);			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Responsable;
		
		
	}
	@RequestMapping(value = "/ListaResponsableservicio", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody ArrayList<Responsable> ListaResponsable(@RequestParam("idservicio")int idservicio,
			@RequestParam("turno")String turno,
			 HttpServletRequest req) {
				ArrayList<Responsable> lista=null;
				
				//
				try
				{
				
					lista=LogicaResponsable.Instancia().Listar(idservicio,turno);
					
				
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return lista;
				
				
			}
	
}
