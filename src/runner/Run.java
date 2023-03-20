/**
 * 
 */
package runner;

import controller.Control;

/**
 * @author JONATAN FRANCO
 *
 */
public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Control control = new Control("no connection");
		control.init();
	}

}
