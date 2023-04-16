package UD22.A1_22;

import controller.ControllerCliente;
import model.Cliente;
import model.ClienteConsultas;
import view.ClienteView;


public class App 
{
    public static void main( String[] args )
    {

    	Cliente cliente = new Cliente();
		ClienteConsultas consultas = new ClienteConsultas();
		ClienteView view = new ClienteView();
		ControllerCliente ctrl = new ControllerCliente(cliente, consultas, view);
		ctrl.iniciar();
		view.setVisible(true);
    	
    }
    
    
   
}
