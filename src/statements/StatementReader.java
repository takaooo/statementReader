package statements;

import java.io.BufferedReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public abstract class StatementReader {

	ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	BufferedReader br;
	SimpleDateFormat parseSDF;

	public abstract ArrayList<Transaction> readStatement(String filename);

	protected abstract void addTrans(String[] trans) throws ParseException;
}
