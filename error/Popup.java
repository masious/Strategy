package error;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Popup extends JOptionPane{
	private static final long serialVersionUID = -294551407157228312L;

	public static void showError(String text) {
		JFrame x = new JFrame();
		x.setLocation(x.getToolkit().getScreenSize().width/2,x.getToolkit().getScreenSize().height/2);
		x.setVisible(true);
		JOptionPane.showMessageDialog(x , "Error" , text , JOptionPane.ERROR_MESSAGE);

	}
}
