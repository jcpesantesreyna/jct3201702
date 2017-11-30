package com.upn.jct3;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Comun.LogicaProgramacion;
import Entidades.Programacion;
import Entidades.Responsable;
import Entidades.Servicio;

@Controller
public class ProgramacionController {

	@RequestMapping(value = "/insertarProgramacion", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody boolean insertarProgramacionl(@RequestParam("idservicio")	int idservicio,
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
		boolean Programacionl=false;
		
		try
		{
			//fechanac="2017-10-10";
			Programacion programacion=new Programacion();
			Servicio servicio=new Servicio();
			servicio.setIdservicio(idservicio);
			programacion.setServicio(servicio);
			Responsable responsable=new Responsable();
			responsable.setIdresposanble(idresponsable);
			programacion.setResponsable(responsable);
			programacion.setTurno(turno);
			programacion.setDialun(dialun);
			programacion.setDiamar(diamar);
			programacion.setDiamie(diamie);
			programacion.setDiajue(diajue);
			programacion.setDiavie(diavie);
			programacion.setDiasab(diasab);
			programacion.setEstado(estado);
			
			Programacionl=LogicaProgramacion.Instancia().Insertar(programacion);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Programacionl;
		
		
	}
	@RequestMapping(value = "/actualizarProgramacion", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody boolean actualizarProgramacion(@RequestParam("idProgramacion")int idProgramacion,
			@RequestParam("apepat")	String apepat,@RequestParam("apemat")	String apemat ,
			@RequestParam("nombres")	String nombres,
			@RequestParam("fechanac")	String fechanac,
			@RequestParam("dni")	String dni,
			@RequestParam("direccion")	String direccion,
			HttpServletRequest req) {
		boolean Programacionl=false;

	
		Programacion Programacion=new Programacion();
		Programacion.setNumProgramacion(idProgramacion);
		
		
		
		try
		{
			Programacion.setApepat(apepat);
			Programacion.setApemat(apemat);
			Programacion.setNombres(nombres);
			Programacion.setFechanac(java.sql.Date.valueOf(fechanac));
			Programacion.setDni(dni);
			Programacion.setDireccion(direccion);
			Programacionl=LogicaProgramacion.Instancia().actualizar(Programacion);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Programacionl;
		
		
	}
	@RequestMapping(value = "/obtenerProgramacion", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody Programacion obtenerProgramacion(@RequestParam("idProgramacion")int idProgramacionl,HttpServletRequest req) {
		Programacion Programacion=null;
		
		try
		{
			Programacion=LogicaProgramacion.Instancia().obtener(idProgramacionl);			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Programacion;
		
		
	}
	@RequestMapping(value = "/ListaProgramacion", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody ArrayList<Programacion> ListaProgramacion(
			 HttpServletRequest req) {
				ArrayList<Programacion> lista=null;
				
				//
				try
				{
				
					lista=LogicaProgramacion.Instancia().Listar();
					
				
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return lista;
				
				
			}
}

