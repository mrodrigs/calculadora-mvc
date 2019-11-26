package calcMVC;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcView extends JFrame{
	private static final String INITIAL_VALUE = "1";
	
	private JTextField m_userInputTf = new JTextField(5);
	private JTextField m_totalTf = new JTextField(20);
	private JButton m_multiplyBtn = new JButton("Multiplicar");
	private JButton m_clearBtn = new JButton("Limpar");
	
	private CalcModel m_model;
	
	
	CalcView(CalcModel model) {
		m_model = model;
		m_model.setValue(INITIAL_VALUE);
		
		m_totalTf.setText(m_model.getValue());
		m_totalTf.setEditable(false);
		
		JPanel content = new JPanel();
		content.setLayout(new FlowLayout());
		content.add(new JLabel("Input"));
		content.add(m_userInputTf);
		content.add(m_multiplyBtn);
		content.add(new JLabel("Total"));
		content.add(m_totalTf);
		content.add(m_clearBtn);
		this.setContentPane(content);
		this.pack();
		
		this.setTitle("Calculadora - MVC");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void reset() {
		m_totalTf.setText(INITIAL_VALUE);
	}
	
	String getUserInput() {
		return m_userInputTf.getText();
	}
	
	void setTotal(String newTotal) {
		m_totalTf.setText(newTotal);
	}
	
	void showError(String errMessage) {
		JOptionPane.showMessageDialog(this, errMessage);
	}
	
	void addMultiplyListener(ActionListener mal) {
		m_multiplyBtn.addActionListener(mal);
	}
	
	void addClearListener(ActionListener cal) {
		m_clearBtn.addActionListener(cal);
	}
}
