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
namespace Escritorio
{
    public partial class FrmLogin : Form
    {
        public FrmLogin()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnIngresar_Click(object sender, EventArgs e)
        {
          string sUrlRequest = "http://servidorfinal.azurewebsites.net/REST/login?sesion="+txtUsuario.Text+"&password="+txtPass.Text;
                      
          //  MessageBox.Show(sUrlRequest);
            var json = new WebClient().DownloadString(sUrlRequest);
            Console.WriteLine("----" + json);
            if(json!=null && json!="")
            {
                MessageBox.Show("ok");

                Form1 form1=new Form1();
                form1.Show();
                this.Hide();
            }
        }
    }
}
