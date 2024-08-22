
import controller.WeirdQuizController;

public class WeirdQuizApp {

	private static WeirdQuizController controller;

	public static void main(String[] args) {
		controller = new WeirdQuizController(args[0]);
		controller.run();
	}

}