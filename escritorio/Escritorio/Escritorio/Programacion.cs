using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Escritorio
{
   public  class Programacion
    {

        private int idprogramacion;
       // private Servicio servicio;
        private Responsable responsable;
        private String turno;
        private int dialun;
        private int diamar;

        private int diamie;
        private int diajue;
        private int diavie;
        private int diasab;
        private bool estado;
        public int getIdprogramacion()
        {
            return idprogramacion;
        }
        public void setIdprogramacion(int idprogramacion)
        {
            this.idprogramacion = idprogramacion;
        }
    
        public Responsable getResponsable()
        {
            return responsable;
        }
        public void setResponsable(Responsable responsable)
        {
            this.responsable = responsable;
        }
        public String getTurno()
        {
            return turno;
        }
        public void setTurno(String turno)
        {
            this.turno = turno;
        }
        public int getDialun()
        {
            return dialun;
        }
        public void setDialun(int dialun)
        {
            this.dialun = dialun;
        }
        public int getDiamar()
        {
            return diamar;
        }
        public void setDiamar(int diamar)
        {
            this.diamar = diamar;
        }
        public int getDiamie()
        {
            return diamie;
        }
        public void setDiamie(int diamie)
        {
            this.diamie = diamie;
        }
        public int getDiajue()
        {
            return diajue;
        }
        public void setDiajue(int diajue)
        {
            this.diajue = diajue;
        }
        public int getDiavie()
        {
            return diavie;
        }
        public void setDiavie(int diavie)
        {
            this.diavie = diavie;
        }
        public int getDiasab()
        {
            return diasab;
        }
        public void setDiasab(int diasab)
        {
            this.diasab = diasab;
        }
        public bool isEstado()
        {
            return estado;
        }
        public void setEstado(bool estado)
        {
            this.estado = estado;
        }

    }
}
