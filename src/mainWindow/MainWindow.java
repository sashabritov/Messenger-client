package mainWindow;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;


public class MainWindow implements ActionListener {
	private String testUserName = "11";
	private String testUserPassword = "11";
	JLabel labelTemplate;
	
	JLabel labelName, labelPassword;
	JTextField nameField;
	JPasswordField passwordField;  
    JButton OKButton, cancelButton; 
    JFrame frame;
    
    MainElementsPanel mainElementsPanel;
    LoginElementsPanel loginElementsPanel;
    
    public MainWindow() {
    	labelTemplate = new JLabel("You are logged in. Here will be the main user interface");
    	
    	mainElementsPanel = new MainElementsPanel();
    	loginElementsPanel = new LoginElementsPanel();
    	frame = new JFrame("Messenger client");
    }
    
	public void createMainWindow() {
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		frame.addWindowListener(new WindowListener() {
			public void windowActivated(WindowEvent event) {}
            public void windowClosed(WindowEvent event) {}
            public void windowDeactivated(WindowEvent event) {}
            public void windowDeiconified(WindowEvent event) {}
            public void windowIconified(WindowEvent event) {}
            public void windowOpened(WindowEvent event) {}
			public void windowClosing(WindowEvent event) {
				closeProgram();
			};
		});
	    
	    labelName = new JLabel("Name:");
	    labelName.setBounds(50,50,150,20); 
	    labelPassword = new JLabel("Password:");
	    labelPassword.setBounds(50,100,150,20); 
	    nameField=new JTextField();  
	    nameField.setBounds(150,50,150,20);  
	    passwordField=new JPasswordField();  
	    passwordField.setEchoChar('*');
	    passwordField.setBounds(150,100,150,20);   
	    OKButton=new JButton("OK");  
	    OKButton.setBounds(50,200, 150, 20);  
	    cancelButton=new JButton("Quit");  
	    cancelButton.setBounds(250,200,150,20);  
        OKButton.addActionListener(this);  
        cancelButton.addActionListener(this);
        frame.add(labelName);
        frame.add(labelPassword);
        frame.add(nameField);
        frame.add(passwordField);
        frame.add(OKButton);
        frame.add(cancelButton);
        
        frame.setLayout(null);
		
		frame.setPreferredSize(new Dimension(1000, 500));
		frame.pack();
		frame.setVisible(true);
	}
	
	private void createMainInterface() {
		frame.remove(labelName);
		frame.remove(labelPassword);
        frame.remove(nameField);
        frame.remove(passwordField);
        frame.remove(OKButton);
        frame.remove(cancelButton);
        frame.getContentPane().removeAll();
        frame.getContentPane().repaint();
        labelTemplate.setBounds(100, 50, 650, 20);
        frame.add(labelTemplate);
	}
	
	private void closeProgram() {
		Object[] options = { "Yes", "No" };
        int rc = JOptionPane.showOptionDialog(
                        frame, "Exit Messenger?",
                        "Confirmation", JOptionPane.YES_NO_OPTION,
                                         JOptionPane.QUESTION_MESSAGE, 
                                         null, options, options[0]);
        if (rc == 0) {
        	frame.setVisible(false);
            System.exit(0);
        }
	}
	
	public static void main(String[] args) {
		/*JFrame.setDefaultLookAndFeelDecorated(true);
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createMainWindow();
			}
		});*/
		new MainWindow().createMainWindow();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == OKButton) {
			String name = nameField.getText();
			String password = new String(passwordField.getPassword());
			if((name.equals(testUserName)) && (password.equals(testUserPassword))) {
				createMainInterface();
			} else { 
				JOptionPane.showMessageDialog(null, "Login and password entered incorrectly", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(event.getSource() == cancelButton) {
			closeProgram();
		}
	}
}
