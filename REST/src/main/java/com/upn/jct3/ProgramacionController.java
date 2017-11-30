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
	public @ResponseBody boolean actualizarProgramacion(@RequestParam("idprogramacion")
	int idprogramacion,
			@RequestParam("idservicio")	int idservicio,@RequestParam("idresponsable")int	idresponsable ,
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

	
		Programacion Programacion=new Programacion();
		
		
		try
		{
			Programacion.setIdprogramacion(idprogramacion);
			Servicio servicio=new Servicio();
			servicio.setIdservicio(idservicio);
			Programacion.setServicio(servicio);
			Responsable responsable=new Responsable();
			responsable.setIdresposanble(idresponsable);
			Programacion.setResponsable(responsable);
			Programacion.setTurno(turno);
			Programacion.setDialun(dialun);
			Programacion.setDiamar(diamar);
			Programacion.setDiamie(diamie);
			Programacion.setDiajue(diajue);
			Programacion.setDiavie(diavie);
			Programacion.setDiasab(diasab);
			Programacion.setEstado(estado);
			
			
			Programacionl=LogicaProgramacion.Instancia().actualizar(Programacion);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Programacionl;
		
		
	}
	@RequestMapping(value = "/obtenerProgramacion", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody Programacion obtenerProgramacion(@RequestParam("idprogramacion")int idProgramacionl,HttpServletRequest req) {
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
	public @ResponseBody ArrayList<Programacion> ListaProgramacion(@RequestParam("idservicio")int idservicio,
			@RequestParam("turno")String turno,HttpServletRequest req
			 ) {
				ArrayList<Programacion> lista=null;
				
				//
				try
				{
				
					lista=LogicaProgramacion.Instancia().Listar(idservicio,turno);
					
				
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return lista;
				
				
			}

@RequestMapping(value = "/ListaProgramacion2", method = RequestMethod.GET,produces="application/json")
public @ResponseBody ArrayList<Programacion> ListaProgramacion2(HttpServletRequest req
		 ) {
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

