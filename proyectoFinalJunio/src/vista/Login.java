package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login extends JFrame {
public Image imagenFondo1, imagenFondo2, imagenFondo3;
public URL fondo, fondo2, fondo3;
private JPanel panel;
private JTextField textFieldLogin;
private JPasswordField passwordField;



	/**
 * @return the textFieldLogin
 */
public JTextField getTextFieldLogin() {
	return textFieldLogin;
}

/**
 * @return the passwordField
 */
public JPasswordField getPasswordField() {
	return passwordField;
}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setResizable(false);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);//centrarla en la ventana
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 638);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		fondo=this.getClass().getResource("barner.PNG");//IMG----------------------------------------------
		imagenFondo1=new ImageIcon(fondo).getImage();//IMG------------------------------------------------------
	
		fondo2=this.getClass().getResource("fondoPanel.PNG");//IMG----------------------------------------------
		imagenFondo2=new ImageIcon(fondo2).getImage();//IMG------------------------------------------------------
		
		
		JPanel panel = new JPanel()
		 
		{//IMG------------------------------
		public void paintComponent(Graphics g) {//IMG------------------------------------------------------------
		  g.drawImage(imagenFondo1, 0, 0, getWidth() , getHeight(), this);//IMG----------------------------------	
		}	//IMG------------------------------------------------------------------------------------------------	
		}
		;//IMG---------------------------------------------------------------------------------------------------
		
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setBorder(new EmptyBorder(140, 5, 5, 5));
		
	
		
		
		   
		
		    JPanel panel0 =new JPanel()
		    {//IMG------------------------------
			public void paintComponent(Graphics g) {//IMG------------------------------------------------------------
		    g.drawImage(imagenFondo2, 0, 0, getWidth() , getHeight(), this);//IMG----------------------------------	
			}	//IMG------------------------------------------------------------------------------------------------	
			}
			;//IMG		
		    		
		    		
		    ;
		  
	       
		
	        getContentPane().add(panel0, BorderLayout.CENTER);
	        panel0.setLayout(null);
	        
	        JLabel lblLogin = new JLabel("Login");
	        lblLogin.setForeground(Color.DARK_GRAY);
	        lblLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
	        lblLogin.setBounds(298, 196, 46, 14);
	        panel0.add(lblLogin);
	        
	        textFieldLogin = new JTextField();
	        textFieldLogin.setBounds(386, 195, 144, 20);
	        panel0.add(textFieldLogin);
	        textFieldLogin.setColumns(10);
	        
	        JLabel lblPass = new JLabel("Pass");
	        lblPass.setForeground(Color.DARK_GRAY);
	        lblPass.setFont(new Font("Tahoma", Font.BOLD, 14));
	        lblPass.setBounds(298, 233, 46, 14);
	        panel0.add(lblPass);
	        
	        passwordField = new JPasswordField();
	        passwordField.setColumns(20);
	        passwordField.setBounds(386, 226, 144, 20);
	        panel0.add(passwordField);
	        
	        JButton btnEntrar = new JButton("ENTRAR");
	        btnEntrar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        	char[] login=passwordField.getPassword();
	        	String pass=new String(login);
	        	
	        	    if(textFieldLogin.getText().equals("login") && (pass.equals("pass"))) {
	        		
	        	        dispose();
	        	
	        	        JOptionPane.showMessageDialog(null, "Bienvenido al sistema", "Has ingresado correctamente", JOptionPane.INFORMATION_MESSAGE);
	        	
	        	        Vista v=new  Vista();
	        	        v.setVisible(true);
	        	
	             	}
	        	
	        	    else {
	        	    	JOptionPane.showMessageDialog(null, "Login o pass incorrecto", "ERROR", JOptionPane.INFORMATION_MESSAGE);
	        	    }
	        	}
	          
	        });
	        btnEntrar.setBounds(387, 274, 118, 41);
	        panel0.add(btnEntrar);
			
		
		}
	}

