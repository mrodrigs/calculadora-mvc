package calcMVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcController {
	private CalcModel m_model;
	private CalcView m_view;
	
	CalcController(CalcModel model, CalcView view) {
		m_model = model;
		m_view = view;
		
		m_view.addMultiplyListener(new MultiplyListener());
		m_view.addClearListener(new ClearListener());
	}
	
	class MultiplyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String userInput = "";
			try {
				userInput = m_view.getUserInput();
				m_model.multiplyBy(userInput);
				m_view.setTotal(m_model.getValue());
			}
			catch (NumberFormatException ex) {
				m_view.showError("Bad input: '" +userInput+"'");
			}
		}
	}
	
	class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			m_model.reset();
			m_view.reset();
		}
	}
}
