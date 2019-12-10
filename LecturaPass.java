package ultimo;

import java.io.IOException;
import java.io.RandomAccessFile;



public class LecturaPass {
	
	private String login, pass;
	private static RandomAccessFile archivo;
	
	public LecturaPass(String login, String pass){
		
		setLogin(login);
		setPass(pass);
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public boolean comparar(){
		String usuario,password;
		boolean res = false;
		try {
			archivo = new RandomAccessFile("Personas.dat", "rw");
			archivo.seek(0);
			while(archivo.getFilePointer() < archivo.length()){
				usuario = archivo.readUTF();
				//Lee nuevamente para asegurarse de que se ha saltado 8 bytes o la cantidad en bytes de un String
				if(getLogin().equals(usuario)){
					password = archivo.readUTF();
					if(getPass().equals(password)){
						res=true;
					}
				}
				archivo.readUTF();
			}
			res = false;
		} catch (IOException e) {
			
		}
		System.out.println(res);
		return res;
		
	}
}
