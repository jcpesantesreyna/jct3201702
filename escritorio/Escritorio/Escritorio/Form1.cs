using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Net;
using Newtonsoft.Json;
using Escritorio;

namespace Escritorio
{
    public partial class Form1 : Form
    {
        DateTime hoy;
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            try
            {



                string sUrlRequest = "http://servidorfinal.azurewebsites.net/REST/ListaServicio";

                var json = new WebClient().DownloadString(sUrlRequest);
                List<Servicio> listaServicio = new List<Servicio>();
                listaServicio = JsonConvert.DeserializeObject <List <Servicio>> (json);
                /*  foreach(Servicio objeto in listaServicio)
                  {

                      cboServicio.Items.Add(objeto.Descripcion +"-"+objeto.Idservicio.ToString());

                  }
                  */
                cboServicio.DataSource = listaServicio;
                cboServicio.ValueMember = "idservicio";
                cboServicio.DisplayMember = "descripcion";
                sUrlRequest = "http://servidorfinal.azurewebsites.net/REST/ListaResponsable";

                var json2 = new WebClient().DownloadString(sUrlRequest);
                List<Responsable> listaResponsable = new List<Responsable>();
                listaResponsable = JsonConvert.DeserializeObject<List<Responsable>>(json2);
                /* foreach (Responsable objeto in listaResponsable)
                 {

                     cboResponsable.Items.Add(objeto.Descripcion + "-" + objeto.Idresponsable.ToString());

                 }
                 */
                cboResponsable.DataSource = listaResponsable;
                cboResponsable.DisplayMember = "descripcion";
                cboResponsable.ValueMember = "idresponsable";
              
            }

            catch (Exception ex)
            {
                MessageBox.Show(ex.Message.ToString());
            }
        }

        private void groupBox1_Enter(object sender, EventArgs e)
        {

        }

        private void monthCalendar1_DateChanged(object sender, DateRangeEventArgs e)
        {

            hoy = monthCalendar1.SelectionStart;
            String servicio;
            String responsable;
            servicio = cboServicio.SelectedValue.ToString();
            //MessageBox.Show(servicio);
            responsable = cboResponsable.SelectedValue.ToString();
            if(cboturno.Text=="")
            {
                MessageBox.Show("Debe seleccionar un turno");
                return ;
            }
            String turno = cboturno.Text.Substring(0, 1);
            //MessageBox.Show(turno);
            turno = turno.ToLower();
            String sUrlRequest = "http://servidorfinal.azurewebsites.net/REST/ListaProgramacion?idservicio=" + servicio + "&turno="+turno ;
            /*
            var json2 = new WebClient().DownloadString(sUrlRequest);
            List<Responsable> listaResponsable = new List<Responsable>();
            listaResponsable = JsonConvert.DeserializeObject<List<Responsable>>(json2);
            foreach (Responsable objeto in listaResponsable)
            {

                cboResponsable.Items.Add(objeto.Descripcion + "-" + objeto.Idresponsable.ToString());

            }*/
        }
    }
}
