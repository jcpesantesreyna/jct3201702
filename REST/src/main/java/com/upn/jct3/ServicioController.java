package com.upn.jct3;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Comun.LogicaServicio;
import Entidades.Servicio;
@Controller
public class ServicioController {

	
	
	@RequestMapping(value = "/insertarServicio", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody boolean insertarServicio(@RequestParam("descripcion")String descripcion,HttpServletRequest req) {
		boolean servicio=false;
		
		try
		{
			servicio=LogicaServicio.Instancia().Insertar(descripcion)		;				
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return servicio;
		
		
	}
	@RequestMapping(value = "/actualizarServicio", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody boolean actualizarServicio(@RequestParam("descripcion")String descripcion,@RequestParam("idservicio")int idservicio,HttpServletRequest req) {
		boolean servicio=false;
		
		try
		{
			servicio=LogicaServicio.Instancia().actualizar(idservicio,descripcion);				
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return servicio;
		
		
	}
	@RequestMapping(value = "/obtenerServicio", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody Servicio obtenerServicio(@RequestParam("idservicio")int idservicio,HttpServletRequest req) {
		Servicio servicio=null;
		
		try
		{
			servicio=LogicaServicio.Instancia().obtener(idservicio);			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return servicio;
		
		
	}
	@RequestMapping(value = "/ListaServicio", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody ArrayList<Servicio> ListaServicio(
			 HttpServletRequest req) {
				ArrayList<Servicio> lista=null;
				
				//
				try
				{
				
					lista=LogicaServicio.Instancia().Listar();
					
				
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return lista;
				
				
			}
	@RequestMapping(value = "/ListaServicio2", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody ArrayList<Servicio> ListaServicio(@RequestParam("turno")String turno,
			 HttpServletRequest req) {
				ArrayList<Servicio> lista=null;
				
				//
				try
				{
				
					lista=LogicaServicio.Instancia().Listar(turno);
					
				
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return lista;
				
				
			}
}
