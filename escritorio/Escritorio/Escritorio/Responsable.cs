using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Escritorio
{
  public  class Responsable
    {

        private int idresponsable;
        private String descripcion;

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

        public int Idresponsable
        {
            get
            {
                return idresponsable;
            }

            set
            {
                idresponsable = value;
            }
        }

        public Responsable(int idresponsable, string descripcion)
        {
            this.Idresponsable = idresponsable;
            this.Descripcion = descripcion;
        }
    }
}
