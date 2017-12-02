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
        public int idusuario = 1;
        Historia historia;
           List<Cita> lista2 = new List<Cita>();
        DateTime hoy;
        Programacion programacion;
        

        private void cboServicio_SelectedIndexChanged(object sender, EventArgs e)
        {/*

           String sUrlRequest = "http://servidorfinal.azurewebsites.net/REST/ListaResponsableservicio?idservicio="+ cboServicio.SelectedValue.ToString();

            var json2 = new WebClient().DownloadString(sUrlRequest);
            Console.WriteLine(json2);
            List<Responsable> listaResponsable = new List<Responsable>();
            listaResponsable = JsonConvert.DeserializeObject<List<Responsable>>(json2);*/
         
            cboResponsable.DataSource = null;
            cboResponsable.DisplayMember = "";
            cboResponsable.ValueMember = "";
            
        }

        private void Consultar_Click(object sender, EventArgs e)
        {
            //Programacion programacion =new Programacion();
            hoy = monthCalendar1.SelectionStart;
            String servicio;
           
            servicio = cboServicio.SelectedValue.ToString();

           
            String turno = cboturno.Text.Substring(0, 1);

            turno = turno.ToLower();
            String sUrlRequest = "http://servidorfinal.azurewebsites.net/REST/ListaProgramacion?idservicio=" + servicio + "&turno=" + turno + "&idresponsable=" + cboResponsable.SelectedValue.ToString() ;
           //  MessageBox.Show(sUrlRequest);
            var json2 = new WebClient().DownloadString(sUrlRequest);

            System.Console.WriteLine(" jason-"+json2);
            List<Programacion> lista = new List<Programacion>();
            lista = JsonConvert.DeserializeObject<List<Programacion>>(json2);
            System.Console.WriteLine(lista);
           // System.Console.WriteLine("  --"+lista[0].Idprogramacion);
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
                txtNombres.Text = historia.Apepat + " "+historia.Apemat+ " "+historia.Nombres;

            }

            catch (Exception ex)
            {
                MessageBox.Show(ex.Message.ToString());
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            try
            {
                if (Convert.ToInt16(txtCupos.Text)<=0)
                {
                    MessageBox.Show("Cupos completos");
                    return;
                }
                int idhistoria = Convert.ToInt16(txthistoria.Text);
                int idprogramacion = programacion.Idprogramacion;
                String dia, mes, anio;
                dia = lblfecha.Text.Substring(0, 2);
                mes = lblfecha.Text.Substring(3, 2);
                anio = lblfecha.Text.Substring(6, 4);
                String fecha = anio + "-" + mes + "-" + dia;
                string sUrlRequest = "http://servidorfinal.azurewebsites.net/REST/insertarCita?idhistoria=";
                sUrlRequest = sUrlRequest + idhistoria.ToString()+"&idusuario="+idusuario.ToString()+"&idprogramacion="+idprogramacion.ToString();
                sUrlRequest = sUrlRequest + "&fecha=" + fecha;
              //  MessageBox.Show(sUrlRequest);
                var json = new WebClient().DownloadString(sUrlRequest);
                //   List<Servicio> listaServicio = new List<Servicio>();
                
                if(json=="true")
                {
                    MessageBox.Show("Ok");
                    monthCalendar1.Refresh();
                }
                else
                {
                    MessageBox.Show("error");
                }
                
            }
            catch(Exception ex)
            {

            }
        
        }

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            try
            {



              
              
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
            try
            {
                string sUrlRequest = "http://servidorfinal.azurewebsites.net/REST/ListaCita?idresponsable=" + cboResponsable.SelectedValue.ToString();

               // MessageBox.Show(cboResponsable.SelectedValue.ToString());
                var json = new WebClient().DownloadString(sUrlRequest);
                List<Cita> listaServicio = new List<Cita>();
                listaServicio = JsonConvert.DeserializeObject<List<Cita>>(json);
                lblfecha.Text = monthCalendar1.SelectionStart.ToShortDateString();
                int cupos = 0;
                String dia, mes, anio;
                dia = lblfecha.Text.Substring(0, 2);
                mes = lblfecha.Text.Substring(3, 2);
                anio = lblfecha.Text.Substring(6, 4);
                String fecha = anio + "-" + mes + "-" + dia;
                foreach (Cita objeto in listaServicio )
                {


                    if (objeto.Fecha.ToString() == fecha && objeto.Programacion.Idprogramacion==programacion.Idprogramacion)
                    {
                        Console.WriteLine("si");
                        cupos = cupos + 1;
                    }

                }
                Console.WriteLine("cupos"+cupos);
                if (monthCalendar1.SelectionStart.DayOfWeek== DayOfWeek.Monday)
                    {

                        cupos = Convert.ToInt16(lblLunes.Text) - cupos;


                    }
                if (monthCalendar1.SelectionStart.DayOfWeek == DayOfWeek.Tuesday)
                {

                    cupos = Convert.ToInt16(lblMartes.Text) - cupos;


                }
                if (monthCalendar1.SelectionStart.DayOfWeek == DayOfWeek.Wednesday)
                {

                    cupos = Convert.ToInt16(lblMiercoles.Text) - cupos;


                }
                if (monthCalendar1.SelectionStart.DayOfWeek == DayOfWeek.Thursday)
                    {

                        cupos = Convert.ToInt16(lblJueves.Text) - cupos;


                    }
                   
                   
                    if (monthCalendar1.SelectionStart.DayOfWeek == DayOfWeek.Friday)
                    {

                        cupos = Convert.ToInt16(lblViernes.Text) - cupos;


                    }
                    if (monthCalendar1.SelectionStart.DayOfWeek == DayOfWeek.Saturday)
                    {

                        cupos = Convert.ToInt16(lblSabado.Text) - cupos;


                    }
                  
               
                txtCupos.Text = cupos.ToString();

            }
            catch (Exception ex)
            {
                
            }
            
           


        }

        private void cboResponsable_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void Form1_FormClosed(object sender, FormClosedEventArgs e)
        {
            Application.Exit();
        }

        private void btnObtenermedicos_Click(object sender, EventArgs e)
        {
      

           String sUrlRequest = "http://servidorfinal.azurewebsites.net/REST/ListaResponsableservicio?idservicio="+ cboServicio.SelectedValue.ToString()+"&turno="+cboturno.Text.Substring(0,1).ToLower();

            var json2 = new WebClient().DownloadString(sUrlRequest);
            Console.WriteLine(json2);
            List<Responsable> listaResponsable = new List<Responsable>();
            listaResponsable = JsonConvert.DeserializeObject<List<Responsable>>(json2);
          
             cboResponsable.DataSource = listaResponsable;
             cboResponsable.DisplayMember = "descripcion";
             cboResponsable.ValueMember = "idresposanble";
        }

        private void button2_Click_1(object sender, EventArgs e)
        {

            string sUrlRequest = "http://servidorfinal.azurewebsites.net/REST/ListaServicio2?turno="+cboturno.Text.Substring(0,1).ToLower();

            var json = new WebClient().DownloadString(sUrlRequest);
            List<Servicio> listaServicio = new List<Servicio>();
            listaServicio = JsonConvert.DeserializeObject<List<Servicio>>(json);
            /*  foreach(Servicio objeto in listaServicio)
              {

                  cboServicio.Items.Add(objeto.Descripcion +"-"+objeto.Idservicio.ToString());

              }
              */
            cboServicio.DataSource = listaServicio;
            cboServicio.ValueMember = "idservicio";
            cboServicio.DisplayMember = "descripcion";
        }
    }
}
