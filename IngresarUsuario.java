package ultimo;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.awt.event.ActionEvent;

public class IngresarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textoUsuario;
	private JPasswordField campoPass, campoPass1;
	private String login, pass, pass1;
	private JButton botonAceptar;
	private JLabel labelUsuario, labelIngreseLaContrasea, labelRepitaLaContrasea;
	private static RandomAccessFile archivo;

	
	public IngresarUsuario() {
		setTitle("INGRESAR NUEVO USUARIO");
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(300, 300, 452, 420);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		labelUsuario = new JLabel("Ingrese el usuario:");
		labelUsuario.setFont(new Font("Calibri", Font.PLAIN, 15));
		labelUsuario.setBounds(64, 78, 168, 25);
		contentPane.add(labelUsuario);
		
		labelIngreseLaContrasea = new JLabel("Ingrese la contrase\u00F1a:");
		labelIngreseLaContrasea.setFont(new Font("Calibri", Font.PLAIN, 15));
		labelIngreseLaContrasea.setBounds(64, 127, 168, 25);
		contentPane.add(labelIngreseLaContrasea);
		
		labelRepitaLaContrasea = new JLabel("Repita la contrase\u00F1a");
		labelRepitaLaContrasea.setFont(new Font("Calibri", Font.PLAIN, 15));
		labelRepitaLaContrasea.setBounds(64, 178, 168, 25);
		contentPane.add(labelRepitaLaContrasea);
		
		textoUsuario = new JTextField();
		textoUsuario.setBounds(222, 78, 140, 25);
		contentPane.add(textoUsuario);
		textoUsuario.setColumns(10);
		
		campoPass = new JPasswordField();
		campoPass.setBounds(222, 127, 140, 25);
		contentPane.add(campoPass);
		
		campoPass1 = new JPasswordField();
		campoPass1.setBounds(222, 180, 140, 25);
		contentPane.add(campoPass1);
		
		botonAceptar = new JButton("ACEPTAR");
		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comparaPass();
			}
		});
		botonAceptar.setBackground(SystemColor.textHighlight);
		botonAceptar.setFont(new Font("Calibri", Font.PLAIN, 15));
		botonAceptar.setBounds(167, 262, 110, 44);
		contentPane.add(botonAceptar);
		
		contentPane.setVisible(true);
		
		
	}
	
	public void comparaPass(){
		pass = String.valueOf(campoPass.getPassword());
		pass1 = String.valueOf(campoPass1.getPassword());
		login = textoUsuario.getText();
		if(pass.equals(pass1)){
			//Compara los objetos tipo String para asegurarse de que se ingreso la clave correctamente
			try {
				archivo = new RandomAccessFile("Personas.dat", "rw");
				try {
					archivo.seek(archivo.length());
					archivo.writeUTF(login);
					archivo.writeUTF(pass);
					archivo.seek(0);
					
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
				}

			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Error en la creacion del archivo");
			}
			
			JOptionPane.showMessageDialog(null, "Ingresado con éxito");
			contentPane.setVisible(false);
			dispose();
		}
		else{
			
			JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden, intente nuevamente");
			textoUsuario.setText("");
			campoPass.setText("");
			campoPass1.setText("");
			
		}
		
	}

}
