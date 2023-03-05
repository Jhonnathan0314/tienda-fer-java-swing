/**
 * 
 */
package controller;

import view.CustomEventAnswer;
import view.IOManager;

/**
 * @author JONATAN FRANCO
 *
 */
public class Control implements CustomEvent {
	//Declaracion de variables
	private CustomEventAnswer answer;

	public void init() {
		Conexion conexion = new Conexion();
		conexion.getConexion();
		
		IOManager frame = new IOManager();
		frame.setVisible(true);
	}

	public CustomEventAnswer getAnswer() {
		return answer;
	}

	public void setAnswer(CustomEventAnswer answer) {
		this.answer = answer;
	}
	
}
