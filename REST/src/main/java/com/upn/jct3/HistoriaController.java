package com.upn.jct3;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Comun.LogicaHistoria;

import Entidades.Historia;
import java.text.DateFormat;
import java.util.ArrayList;

import java.sql.Date;


@Controller
public class HistoriaController {
	@RequestMapping(value = "/insertarHistoria", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody boolean insertarHistorial(@RequestParam("apepat")	String apepat,@RequestParam("apemat")	String apemat ,
			@RequestParam("nombres")	String nombres,
			@RequestParam("fechanac")	String fechanac,
			@RequestParam("dni")	String dni,
			@RequestParam("direccion")	String direccion,HttpServletRequest req) {
		boolean Historial=false;
		
		try
		{
			//fechanac="2017-10-10";
			Historia historia=new Historia();
			
			historia.setApepat(apepat);
			historia.setApemat(apemat);
			historia.setNombres(nombres);
			historia.setFechanac(java.sql.Date.valueOf(fechanac));
			historia.setDni(dni);
			historia.setDireccion(direccion);		;				
			Historial=LogicaHistoria.Instancia().Insertar(historia);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Historial;
		
		
	}
	@RequestMapping(value = "/actualizarHistoria", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody boolean actualizarHistoria(@RequestParam("idhistoria")int idhistoria,
			@RequestParam("apepat")	String apepat,@RequestParam("apemat")	String apemat ,
			@RequestParam("nombres")	String nombres,
			@RequestParam("fechanac")	String fechanac,
			@RequestParam("dni")	String dni,
			@RequestParam("direccion")	String direccion,
			HttpServletRequest req) {
		boolean Historial=false;

	
		Historia historia=new Historia();
		historia.setNumhistoria(idhistoria);
		
		
		
		try
		{
			historia.setApepat(apepat);
			historia.setApemat(apemat);
			historia.setNombres(nombres);
			historia.setFechanac(java.sql.Date.valueOf(fechanac));
			historia.setDni(dni);
			historia.setDireccion(direccion);
			Historial=LogicaHistoria.Instancia().actualizar(historia);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Historial;
		
		
	}
	@RequestMapping(value = "/obtenerHistoria", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody Historia obtenerHistoria(@RequestParam("idhistoria")int idhistorial,HttpServletRequest req) {
		Historia Historia=null;
		
		try
		{
			Historia=LogicaHistoria.Instancia().obtener(idhistorial);			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Historia;
		
		
	}
	@RequestMapping(value = "/ListaHistoria", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody ArrayList<Historia> ListaHistoria(
			 HttpServletRequest req) {
				ArrayList<Historia> lista=null;
				
				//
				try
				{
				
					lista=LogicaHistoria.Instancia().Listar();
					
				
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return lista;
				
				
			}
}
