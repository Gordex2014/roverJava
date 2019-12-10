package ultimo;

import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.SystemColor;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;


public class ControlRobot extends JFrame {

	
	private ImageIcon arriba, abajo, izquierda, derecha;
	private Icon arr, aba, izq, der;
	private JButton botonIzquierda, botonDerecha, botonAbajo, botonArriba, botonSalir;

	public ControlRobot() {
		setBackground(SystemColor.activeCaption);
		getContentPane().setBackground(SystemColor.textHighlight);
		setLocation(1350, 400);
		setSize(500, 500);
		setTitle("CONTROL DEL ROBOT");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Gordex\\workspace\\Ventana\\doncangrejo.png"));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);
		iniciarComponentes();
	}
	public void iniciarComponentes(){
		
		botonIzquierda = new JButton("");
		botonIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sockets socketIzquierda = new Sockets("izquierda");
				/*Se crea un objeto de tipo Sockets dándole como parámetro de contructor la dirección a moverse, se crea el objeto 
				 * específico para la dirección, dado que si se creara un solo objeto y si se lo implementaría de forma de métodos, 
				 * es decir la dirección a moverse, deberían implementarse hilos, para ejecutar la acción en segundo plano, como
				 * se verá en la aplicación de Android.
				 */
			}
		});
		botonIzquierda.setBounds(51, 157, 64, 64);
		izquierda = new ImageIcon("izquierda.png");
		izq = new ImageIcon(izquierda.getImage().getScaledInstance(botonIzquierda.getWidth(), botonIzquierda.getHeight(), Image.SCALE_DEFAULT));
		botonIzquierda.setIcon(izq);
		getContentPane().add(botonIzquierda);
		
		botonDerecha = new JButton("");
		botonDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sockets socketDerecha = new Sockets("derecha");
				/*Se crea un objeto de tipo Sockets dándole como parámetro de contructor la dirección a moverse, se crea el objeto 
				 * específico para la dirección, dado que si se creara un solo objeto y si se lo implementaría de forma de métodos, 
				 * es decir la dirección a moverse, deberían implementarse hilos, para ejecutar la acción en segundo plano, como
				 * se verá en la aplicación de Android.
				 */
			}
		});
		botonDerecha.setBounds(213, 157, 64, 64);
		derecha = new ImageIcon("derecha.png");
		der = new ImageIcon(derecha.getImage().getScaledInstance(botonDerecha.getWidth(), botonDerecha.getHeight(), Image.SCALE_DEFAULT));
		botonDerecha.setIcon(der);
		getContentPane().add(botonDerecha);
		
		botonAbajo = new JButton("");
		botonAbajo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sockets socketAbajo = new Sockets("back");
				/*Se crea un objeto de tipo Sockets dándole como parámetro de contructor la dirección a moverse, se crea el objeto 
				 * específico para la dirección, dado que si se creara un solo objeto y si se lo implementaría de forma de métodos, 
				 * es decir la dirección a moverse, deberían implementarse hilos, para ejecutar la acción en segundo plano, como
				 * se verá en la aplicación de Android.
				 */
			}
		});
		botonAbajo.setBounds(134, 245, 64, 64);
		abajo = new ImageIcon("abajo.png");
		aba = new ImageIcon(abajo.getImage().getScaledInstance(botonAbajo.getWidth(), botonAbajo.getHeight(), Image.SCALE_DEFAULT));
		botonAbajo.setIcon(aba);
		getContentPane().add(botonAbajo);
		
		botonArriba = new JButton("");
		botonArriba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sockets socketArriba = new Sockets("arriba");
				/*Se crea un objeto de tipo Sockets dándole como parámetro de contructor la dirección a moverse, se crea el objeto 
				 * específico para la dirección, dado que si se creara un solo objeto y si se lo implementaría de forma de métodos, 
				 * es decir la dirección a moverse, deberían implementarse hilos, para ejecutar la acción en segundo plano, como
				 * se verá en la aplicación de Android.
				 */
			}
		});
		botonArriba.setBounds(134, 71, 64, 64);
		arriba = new ImageIcon("arriba.png");
		arr = new ImageIcon(arriba.getImage().getScaledInstance(botonArriba.getWidth(), botonArriba.getHeight(), Image.SCALE_DEFAULT));
		botonArriba.setIcon(arr);
		getContentPane().add(botonArriba);
		
		botonSalir = new JButton("SALIR");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		botonSalir.setBackground(Color.RED);
		botonSalir.setForeground(Color.BLACK);
		botonSalir.setFont(new Font("Calibri", Font.PLAIN, 20));
		botonSalir.setBounds(254, 351, 174, 45);
		getContentPane().add(botonSalir);
		
	}

}
