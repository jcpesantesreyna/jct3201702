using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Escritorio
{
  public  class Responsable
    {

        private int idresposanble;
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

        public int Idresposanble
        {
            get
            {
                return idresposanble;
            }

            set
            {
                idresposanble = value;
            }
        }

        public Responsable(int idresponsable, string descripcion)
        {
            this.Idresposanble = idresponsable;
            this.Descripcion = descripcion;
        }
    }
}
