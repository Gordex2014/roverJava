package ultimo;


import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class PrimeraVentana extends JFrame {
	//Hereda métodos de la super clase JFrame para crear ventanas
	private JButton loginboton;
	private JLabel LabelTitulo, labelCarro, labelUsuario, labelPass;
	private JPanel panelPrincipal;
	private JScrollPane scrollPane;
	private JTextField textoUsuario;
	private JPasswordField campoPass;
	private int i=0;
	
	public PrimeraVentana() {
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension screenSize = t.getScreenSize();
		setSize(screenSize.width, screenSize.height);
		setTitle("ROBOT M\u00D3VIL DE EXPLORACI\u00D3N");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Gordex\\workspace\\Ventana\\calamardo.png"));
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
		LabelTitulo.setText("ROBOT M\u00D3VIL DE EXPLORACI\u00D3N");
		LabelTitulo.setForeground(SystemColor.textHighlight);
		LabelTitulo.setFont(new Font("Calibri", Font.PLAIN, 75));
		LabelTitulo.setBounds(380, 50, 1145, 125);
		
		labelCarro = new JLabel();
		labelCarro.setBounds(0, 220, 1280, 720);
		Image img = new ImageIcon(this.getClass().getResource("/robot.png")).getImage();
		labelCarro.setIcon(new ImageIcon(img));
		
		
		scrollPane.setViewportView(panelPrincipal);
		
		panelPrincipal.add(LabelTitulo);
		panelPrincipal.add(labelCarro);
		
		textoUsuario = new JTextField();
		textoUsuario.setFont(new Font("Calibri", Font.PLAIN, 24));
		textoUsuario.setBounds(1567, 435, 267, 40);
		panelPrincipal.add(textoUsuario);
		textoUsuario.setColumns(10);
		
		labelUsuario = new JLabel("Usuario:");
		labelUsuario.setFont(new Font("Calibri", Font.PLAIN, 24));
		labelUsuario.setBounds(1387, 435, 138, 40);
		panelPrincipal.add(labelUsuario);
		
		labelPass = new JLabel("Contrase\u00F1a:");
		labelPass.setFont(new Font("Calibri", Font.PLAIN, 24));
		labelPass.setBounds(1387, 534, 138, 40);
		panelPrincipal.add(labelPass);
		
		campoPass = new JPasswordField();
		campoPass.setText("");
		campoPass.setBounds(1567, 534, 267, 40);
		panelPrincipal.add(campoPass);
		
		loginboton = new JButton("INGRESAR");
		loginboton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String password = String.valueOf(campoPass.getPassword());
				LecturaPass lectura = new LecturaPass(textoUsuario.getText(),password);
				/*Se crea un objeto de tipo LecturaPass y en el constructor se le da como parámetro
				el usuario y el pass ingresados */
				boolean leer = lectura.comparar();
				//Se usa el método comparar del objeto lectura, que devuelve un valor booleano
				if(leer==true){
					if(i<3){
						JOptionPane.showMessageDialog(null, "Ingreso con éxito");
						setVisible(false);
						SegundaVentana segundaVentana = new SegundaVentana();
						segundaVentana.setVisible(true);
						/*Se pone visible la segunda ventana, siendo este el único modo de acceder al panel de
						 * control de usuario
						 */
					}
				}
				else{
					if(i>=3){
						JOptionPane.showMessageDialog(null, "Máximos intentos excedidos");
						setVisible(false);
						dispose();
					}
					System.out.println(lectura.comparar());
					System.out.println(i);
					i++;
					textoUsuario.setText("");
					campoPass.setText("");
					
				}

			}
		});
		loginboton.setFont(new Font("Calibri", Font.PLAIN, 24));
		loginboton.setBackground(SystemColor.textHighlight);
		loginboton.setForeground(Color.BLACK);
		loginboton.setBounds(1503, 667, 195, 56);
		panelPrincipal.add(loginboton);
		
		getContentPane().add(scrollPane);
		
		
	}
}
