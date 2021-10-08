package mainWindow;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainElementsPanel extends JPanel {
	MainElementsPanel() {
		super();
		
		JLabel labelTemplate = new JLabel("Тут буде головний користувацький інтерфейс");
		this.add(labelTemplate);
	}
}
