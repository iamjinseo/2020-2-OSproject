package homework9;
import javax.swing.*;
import java.awt.*;

class NorthPanel extends JPanel {
	public NorthPanel() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(new FlowLayout());
		add(new JButton("Open"));
		add(new JButton("Read"));
		add(new JButton("Close"));
	}
}

class CenterPanel extends JPanel {
	public CenterPanel() {
		setLayout(null);
		JLabel hello = new JLabel("Hello");
		JLabel java = new JLabel("Java");
		JLabel love = new JLabel("Love");
		
		hello.setBounds(30, 100, 200, 20);
		java.setBounds(50, 50, 200, 20);
		love.setBounds(200, 10, 200, 20);
		
		add(hello);
		add(java);
		add(love);
	}
}

public class Quiz9Weeks extends JFrame {
	Quiz9Weeks(){
		setTitle("Open Challenger 9");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		NorthPanel north = new NorthPanel();
		CenterPanel center = new CenterPanel();
		add(north, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new Quiz9Weeks();
	}

}
