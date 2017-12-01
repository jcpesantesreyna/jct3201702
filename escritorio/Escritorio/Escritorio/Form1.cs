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
using System.Globalization;

namespace Escritorio
{
    public partial class Form1 : Form
    {
        Historia historia;
           List<Cita> lista2 = new List<Cita>();
        DateTime hoy;
        Programacion programacion;
        

        private void cboServicio_SelectedIndexChanged(object sender, EventArgs e)
        {
         
        }

        private void Consultar_Click(object sender, EventArgs e)
        {
            //Programacion programacion =new Programacion();
            hoy = monthCalendar1.SelectionStart;
            String servicio;
            String responsable;
            servicio = cboServicio.SelectedValue.ToString();

            responsable = cboResponsable.SelectedValue.ToString();
            if (cboturno.Text == "")
            {
                MessageBox.Show("Debe seleccionar un turno");
                return;
            }
            String turno = cboturno.Text.Substring(0, 1);

            turno = turno.ToLower();
            String sUrlRequest = "http://servidorfinal.azurewebsites.net/REST/ListaProgramacion?idservicio=" + servicio + "&turno=" + turno;
             MessageBox.Show(sUrlRequest);
            var json2 = new WebClient().DownloadString(sUrlRequest);

            System.Console.WriteLine(" jason-"+json2);
            List<Programacion> lista = new List<Programacion>();
            lista = JsonConvert.DeserializeObject<List<Programacion>>(json2);
            System.Console.WriteLine(lista);
            System.Console.WriteLine("  --"+lista[0].Idprogramacion);
            if (lista.Count() > 0)
            {
                programacion = lista.ElementAt(0);
                System.Console.WriteLine("  --" + lista.ElementAt(0).Idprogramacion);
            }
            else
            {
                MessageBox.Show("sin datos");
                return;
            }
            lblLunes.Text = programacion.Dialun.ToString();
            lblMartes.Text = programacion.Diamar.ToString();
            lblMiercoles.Text = programacion.Diamie.ToString();
            lblJueves.Text = programacion.Diajue.ToString();
            lblViernes.Text = programacion.Diavie.ToString();
            lblSabado.Text = programacion.Diasab.ToString();
            foreach (Programacion objeto in lista)
            {
                programacion = objeto;

                

                break;



            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            try
            {



                string sUrlRequest = "http://servidorfinal.azurewebsites.net/REST/obtenerHistoria?idhistoria="+txthistoria.Text;

                var json = new WebClient().DownloadString(sUrlRequest);
             //   List<Servicio> listaServicio = new List<Servicio>();
               historia= JsonConvert.DeserializeObject<Historia>(json);
                txtNombres.Text = historia.Apepat;

            }

            catch (Exception ex)
            {
                MessageBox.Show(ex.Message.ToString());
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            MessageBox.Show(programacion.Idprogramacion.ToString());
        }

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

            string sUrlRequest = "http://servidorfinal.azurewebsites.net/REST/ListaCita?idresponsable=" + cboResponsable.SelectedValue.ToString(); ;
            MessageBox.Show(cboResponsable.SelectedValue.ToString());
            var json = new WebClient().DownloadString(sUrlRequest);
            List<Servicio> listaServicio = new List<Servicio>();
            listaServicio = JsonConvert.DeserializeObject<List<Servicio>>(json);
            lblfecha.Text = monthCalendar1.SelectionStart.ToShortDateString();
            foreach (Servicio objeto in listaServicio)
              {

                  cboServicio.Items.Add(objeto.Descripcion +"-"+objeto.Idservicio.ToString());

              }
             

           


        }

        
    }
}
