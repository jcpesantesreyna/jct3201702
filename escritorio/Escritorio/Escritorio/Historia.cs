using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Escritorio
{
    public class Historia
    {
        private int numhistoria;
        private String apepat;
        private String apemat;
        private String nombres;
        private String fechanac;
        private String dni;
        private String direccion;

        public int Numhistoria
        {
            get
            {
                return numhistoria;
            }

            set
            {
                numhistoria = value;
            }
        }

        public string Apepat
        {
            get
            {
                return apepat;
            }

            set
            {
                apepat = value;
            }
        }

        public string Apemat
        {
            get
            {
                return apemat;
            }

            set
            {
                apemat = value;
            }
        }

        public string Nombres
        {
            get
            {
                return nombres;
            }

            set
            {
                nombres = value;
            }
        }

        public string Fechanac
        {
            get
            {
                return fechanac;
            }

            set
            {
                fechanac = value;
            }
        }

        public string Dni
        {
            get
            {
                return dni;
            }

            set
            {
                dni = value;
            }
        }

        public string Direccion
        {
            get
            {
                return direccion;
            }

            set
            {
                direccion = value;
            }
        }
    }
}
