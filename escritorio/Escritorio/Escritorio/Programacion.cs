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
        private Servicio servicio;
        private Responsable responsable;
        private String turno;
        private int dialun;
        private int diamar;

        private int diamie;
        private int diajue;
        private int diavie;
        private int diasab;
        private bool estado;

        public int Idprogramacion
        {
            get
            {
                return idprogramacion;
            }

            set
            {
                idprogramacion = value;
            }
        }

        internal Servicio Servicio
        {
            get
            {
                return servicio;
            }

            set
            {
                servicio = value;
            }
        }

        public Responsable Responsable
        {
            get
            {
                return responsable;
            }

            set
            {
                responsable = value;
            }
        }

        public string Turno
        {
            get
            {
                return turno;
            }

            set
            {
                turno = value;
            }
        }

        public int Dialun
        {
            get
            {
                return dialun;
            }

            set
            {
                dialun = value;
            }
        }

        public int Diamar
        {
            get
            {
                return diamar;
            }

            set
            {
                diamar = value;
            }
        }

        public int Diamie
        {
            get
            {
                return diamie;
            }

            set
            {
                diamie = value;
            }
        }

        public int Diajue
        {
            get
            {
                return diajue;
            }

            set
            {
                diajue = value;
            }
        }

        public int Diavie
        {
            get
            {
                return diavie;
            }

            set
            {
                diavie = value;
            }
        }

        public int Diasab
        {
            get
            {
                return diasab;
            }

            set
            {
                diasab = value;
            }
        }

        public bool Estado
        {
            get
            {
                return estado;
            }

            set
            {
                estado = value;
            }
        }
    }
}
