package ultimo;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Sockets {
	
	private Socket misocket;
	private DataOutputStream flujo_salida;
	private String ip = "192.168.1.3";
	private int puerto = 12345;
	/*En el caso de cambiar la ruta de IP, se configura manualmente la misma en el raspberry pi o se cambia de ruta en el
	programa.*/
	
	public Sockets(String direccion){
		
		//constructor donde se le da como parámetro la dirección
		
		String caracter = String.valueOf(direccion.charAt(0));;
		
		try {
			
			misocket = new Socket(ip,puerto);
			
			flujo_salida = new DataOutputStream(misocket.getOutputStream());
			
			flujo_salida.writeUTF(caracter);
			
			flujo_salida.close();
			
		} catch (IOException e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}

}
