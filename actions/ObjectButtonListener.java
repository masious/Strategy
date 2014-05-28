package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import environment.Editor;

public class ObjectButtonListener implements ActionListener{

	private JButton that;
	public ObjectButtonListener(JButton that) {
		this.that = that;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		((Editor)(that.getParent().getParent().getParent().getParent().getParent())).select(that.getText());
	}

}
