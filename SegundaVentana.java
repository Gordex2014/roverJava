package ultimo;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class SegundaVentana extends JFrame {

	private JPanel panelPrincipal;
	private JScrollPane scrollPane;
	private JButton botonUsuario, botonInfo, botonControl, botonCamara, botonSalida;
	private JLabel labelCarro, LabelTitulo;

	public SegundaVentana() {
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension screenSize = t.getScreenSize();
		setSize(screenSize.width, screenSize.height);
		setTitle("ROBOT M\u00D3VIL DE EXPLORACI\u00D3N");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Gordex\\workspace\\Ventana\\patricio.png"));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();

	}
	
	private void iniciarComponentes(){
		
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension screenSize = t.getScreenSize();
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 10, screenSize.width+10, screenSize.height+10);
		
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.LIGHT_GRAY);
		panelPrincipal.setLayout(null);
		panelPrincipal.setPreferredSize(new Dimension(screenSize.width-100,screenSize.height-100));
		
		LabelTitulo = new JLabel();
		LabelTitulo.setText("BIENVENIDO A TU ROBOT");
		LabelTitulo.setForeground(SystemColor.textHighlight);
		LabelTitulo.setFont(new Font("Calibri", Font.PLAIN, 75));
		LabelTitulo.setBounds(528, 50, 997, 125);
		panelPrincipal.add(LabelTitulo);
		
		labelCarro = new JLabel();
		labelCarro.setBounds(550, 350, 465, 404);
		Image img = new ImageIcon(this.getClass().getResource("/Rover.png")).getImage();
		labelCarro.setIcon(new ImageIcon(img));
		panelPrincipal.add(labelCarro);
		
		botonUsuario = new JButton("AGREGAR NUEVO USUARIO");
		botonUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				IngresarUsuario nuevoUsuario = new IngresarUsuario();
				nuevoUsuario.setVisible(true);
				/*Se pone visible la ventana de IngresarUsuario creando un objeto de la clase IngresarUsuario y poniendolo visible*/
				
			}
		});
		botonUsuario.setBackground(SystemColor.textHighlight);
		botonUsuario.setForeground(Color.BLACK);
		botonUsuario.setFont(new Font("Calibri", Font.PLAIN, 20));
		botonUsuario.setBounds(1626, 218, 278, 62);
		panelPrincipal.add(botonUsuario);
		
		botonInfo = new JButton("ACERCA DEL PROYECTO");
		botonInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Descripcion descripcion = new Descripcion();
				descripcion.setVisible(true);
				/*Se pone visible la ventana de la descripción del proyecto con el uso de un objeto de tipo Descripción*/
			}
		});
		botonInfo.setBackground(SystemColor.textHighlight);
		botonInfo.setFont(new Font("Calibri", Font.PLAIN, 20));
		botonInfo.setBounds(1626, 399, 278, 62);
		panelPrincipal.add(botonInfo);
		
		scrollPane.setViewportView(panelPrincipal);
		
		botonControl = new JButton("CONTROL DEL ROBOT");
		botonControl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlRobot control = new ControlRobot();
				control.setVisible(true);
				/*Se pone visible la ventana de la descripción del proyecto con el uso de un objeto de tipo ControlRobot*/
			}
		});
		botonControl.setForeground(Color.BLACK);
		botonControl.setFont(new Font("Calibri", Font.PLAIN, 20));
		botonControl.setBackground(SystemColor.textHighlight);
		botonControl.setBounds(1626, 578, 278, 62);
		panelPrincipal.add(botonControl);
		
		botonCamara = new JButton("MOSTRAR C\u00C1MARA");
		botonCamara.setFocusable(false);
		botonCamara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Déjale tomar su tiempo");
				try {
					Process proc = Runtime.getRuntime().exec("java -jar EjecutableWindow.jar");
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
				/*Acá es algo especial, primero se exportó un archivo ejecutable .jar dadas las incompatibilidades de la
				 * librería openCV, luego se llama al ejecutable, en el cual la función de extraer video desde la nube se
				 * encuenta en el main del mismo ejecutable.
				 */

			}
		});

		botonCamara.setForeground(Color.BLACK);
		botonCamara.setFont(new Font("Calibri", Font.PLAIN, 20));
		botonCamara.setBackground(SystemColor.textHighlight);
		botonCamara.setBounds(1626, 764, 278, 62);
		panelPrincipal.add(botonCamara);
		
		botonSalida = new JButton("SALIR");
		botonSalida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
				//Se cierra todo
			}
		});
		botonSalida.setForeground(Color.BLACK);
		botonSalida.setFont(new Font("Calibri", Font.PLAIN, 20));
		botonSalida.setFocusable(false);
		botonSalida.setBackground(Color.RED);
		botonSalida.setBounds(0, 764, 278, 62);
		panelPrincipal.add(botonSalida);
		
		getContentPane().add(scrollPane);
	}
}
