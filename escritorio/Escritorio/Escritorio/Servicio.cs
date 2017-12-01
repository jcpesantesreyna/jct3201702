using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Escritorio
{
    class Servicio
    {
  
            private int idservicio;
            private string descripcion;

        public int Idservicio
        {
            get
            {
                return idservicio;
            }

            set
            {
                idservicio = value;
            }
        }

        public string Descripcion
        {
            get
            {
                return descripcion;
            }

            set
            {
                descripcion = value;
            }
        }
    }

}

