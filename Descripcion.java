package ultimo;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Descripcion extends JFrame {

	private JPanel panelPrincipal;
	private JScrollPane scrollPane;
	private JButton botonSalida;
	private JLabel labelCarro;

	public Descripcion() {
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension screenSize = t.getScreenSize();
		setSize(screenSize.width, screenSize.height);
		setTitle("DESCRIPCION DEL PROYECTO");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Gordex\\workspace\\Ventana\\puff.png"));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
		
		labelCarro = new JLabel();
		labelCarro.setBounds(5, 5, 1900, 900);
		Image img = new ImageIcon(this.getClass().getResource("/descripcion.png")).getImage();
		labelCarro.setIcon(new ImageIcon(img));
		panelPrincipal.add(labelCarro);
		
		scrollPane.setViewportView(panelPrincipal);
		
		botonSalida = new JButton("SALIR");
		botonSalida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		botonSalida.setForeground(Color.BLACK);
		botonSalida.setFont(new Font("Calibri", Font.PLAIN, 20));
		botonSalida.setFocusable(false);
		botonSalida.setBackground(Color.RED);
		botonSalida.setBounds(810, 940, 300, 65);
		panelPrincipal.add(botonSalida);
		
		getContentPane().add(scrollPane);
	}
}