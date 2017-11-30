package com.upn.jct3;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Comun.LogicaCita;
import Entidades.Cita;
import Entidades.Historia;
import Entidades.Programacion;
import Entidades.Responsable;
import Entidades.Servicio;
import Entidades.Usuario;

@Controller
public class CitaController {

	@RequestMapping(value = "/insertarCita", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody boolean insertarCital(@RequestParam("idusuario")	int idusuario,
			@RequestParam("idhistoria")	int idhistoria,
			@RequestParam("fecha")String fecha,
			@RequestParam("idprogramacion")	int idprogramacion,
			
			
			HttpServletRequest req) {
		boolean Cital=false;
		
		try
		{
			//fechanac="2017-10-10";
			Cita Cita=new Cita();
			Usuario usuario=new Usuario();
			usuario.setIdUsuario(idusuario);
				Historia historia=new Historia();
				historia.setNumhistoria(idhistoria);
				Programacion programacion=new Programacion();
				programacion.setIdprogramacion(idprogramacion);
			Cita.setUsuario(usuario);
			Cita.setHistoria(historia);
			Cita.setProgramacion(programacion);
			Cita.setFecha(java.sql.Date.valueOf(fecha));
			
			
			
			
			Cital=LogicaCita.Instancia().Insertar(Cita);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Cital;
		
		
	}
	@RequestMapping(value = "/actualizarCita", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody boolean actualizarCita(@RequestParam("idcita")
	int idcita,
	@RequestParam("idusuario")	int idusuario,
	@RequestParam("idhistoria")	int idhistoria,
	@RequestParam("fecha")String fecha,
	@RequestParam("idprogramacion")	int idprogramacion,
			
			HttpServletRequest req) {
		boolean Cital=false;

	
		
		
		try
		{
			Cita Cita=new Cita();
			Usuario usuario=new Usuario();
			Cita.setIdcita(idcita);
			usuario.setIdUsuario(idusuario);
				Historia historia=new Historia();
				historia.setNumhistoria(idhistoria);
				Programacion programacion=new Programacion();
				programacion.setIdprogramacion(idprogramacion);
			Cita.setUsuario(usuario);
			Cita.setHistoria(historia);
			Cita.setProgramacion(programacion);
			Cita.setFecha(java.sql.Date.valueOf(fecha));
			
			
			
			Cital=LogicaCita.Instancia().actualizar(Cita);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Cital;
		
		
	}
	@RequestMapping(value = "/obtenerCita", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody Cita obtenerCita(@RequestParam("idcita")int idcita,HttpServletRequest req) {
		Cita Cita=null;
		
		try
		{
			Cita=LogicaCita.Instancia().obtener(idcita);			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Cita;
		
		
	}
	@RequestMapping(value = "/ListaCita", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody ArrayList<Cita> ListaCita(@RequestParam("idresponsable")int idresponsable
			,HttpServletRequest req
			 ) {
				ArrayList<Cita> lista=null;
				
				//
				try
				{
				
					lista=LogicaCita.Instancia().Listar(idresponsable);
					
				
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return lista;
				
				
			}
}

