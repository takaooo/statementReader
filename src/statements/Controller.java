package statements;


/*
creates and starts a new controller which then creates the readers and reads the statement files
 */
public class Controller {
	public static void main(String[] Args) {
		Controller controller = new Controller();
		controller.start();
	}

	String directory = "/Users/takao/PycharmProjects/statments";
	String halifax1 = "halifaxc1.csv";
	String amex = "amex.csv";

	private void start() {
		StatementReader reader = new AmexStatementReader();
		reader.readStatement(directory + amex);
	}
}
