package ultimo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.FrameGrabber.Exception;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import java.awt.event.ActionListener;

/*
 * El motivo del porque este código está totalmente incluído en el main
 * es porque existen problemas al usar la librería OpenCv, teniendo mal-
 * funcionamientos al crear funciones para su uso, al igual que con el
 * uso de los botones. Para usar este código se exporta un ejecutable.
 */

public class EjecutableVideo {

	public static void main(String[] args) throws Exception {
		OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber("http://192.168.1.3:8081/video.mjpg"); 
		frameGrabber.setFormat("mjpeg");
		frameGrabber.start();
		IplImage iPimg = frameGrabber.grab();
    
		CanvasFrame c = new CanvasFrame("TRANSMISIÓN DE VÍDEO");
		c.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Gordex\\workspace\\Ventana\\bobesponja.png"));
		c.setLocation(0, 0);
		c.setPreferredSize(new Dimension(1295,920));
		c.setDefaultCloseOperation(CanvasFrame.EXIT_ON_CLOSE);
		c.getContentPane().setLayout(null);
		
		JButton boton = new JButton("SALIR");
		boton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				c.setVisible(false);
				c.dispose();
				System.exit(0);
			}
		});
		boton.setBounds(440, 750, 400, 50);
		boton.setBackground(SystemColor.RED);
		boton.setForeground(Color.BLACK);
		boton.setFont(new Font("Calibri", Font.PLAIN, 20));
		c.getContentPane().add(boton);
		c.setVisible(true);
		
		while ((iPimg = frameGrabber.grab()) != null) {
			c.showImage(iPimg);
			continue;
		}
		frameGrabber.stop();
		c.dispose();
		System.exit(0);
	}
}