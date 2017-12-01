using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Escritorio
{
    class Cita
    {
        private int idcita;
     //   private Usuario usuario;
       // private Historia historia;
        private Programacion programacion;
        private String fecha;

        public Programacion Programacion
        {
            get
            {
                return programacion;
            }

            set
            {
                programacion = value;
            }
        }

        public string Fecha
        {
            get
            {
                return fecha;
            }

            set
            {
                fecha = value;
            }
        }

        public int Idcita
        {
            get
            {
                return idcita;
            }

            set
            {
                idcita = value;
            }
        }

        
    }
}
