package statements;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * amex data structure: Date,Description,Category,Amount skip - 12
 */
public class AmexStatementReader extends StatementReader {

	public AmexStatementReader() {
		parseSDF = new SimpleDateFormat("dd MMM yyyy");
	}

	@Override
	public ArrayList<Transaction> readStatement(String filename) {
		String line;
		try {
			br = new BufferedReader(new FileReader(filename));
			int count = 0;
			while ((line = br.readLine()) != null) {
				count++;
				if (count > 13) {
					String[] trans = line.split(",");
                    System.out.println("before " + count);
                    for(int i = 0; i< trans.length; i++){
                        System.out.println(trans[i]);
                    }
                    trans = checkLine(trans);
					addTrans(trans);

				}
			}

			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return transactions;
	}

    private String[] checkLine(String[] trans){
        String[] line = new String[4];

        //get rid of "#,###"
        for(int i = 0 ; i < 4; i++){
            if(trans[i] != null &&
                    trans[i].length() > 0 &&
                    trans[i].charAt(0) == Character.toChars(34)[0]){
                line[i]=trans[i]+trans[i+1];
                i++;
            }else{
                line[i] = trans[i];
            }
        }

        //clear any strange characters
        for(int i = 0 ; i < 4 ; i++){
            line[i] = line[i].replaceAll("[^\\w*\\s\\-]","");
        }


        return line;
    }

	@Override
	protected void addTrans(String[] trans) {
        try {
			System.out.println("creating Transaction: ");
			System.out.println("[ amex, " + trans[1] + ","
					+ Long.parseLong(trans[3]) + ", "
					+ parseSDF.parse(trans[0]) + " ]");

			Transaction transaction = new Transaction("amex", trans[1],
					Long.parseLong(trans[3]),
					parseSDF.parse(trans[0]),
                    trans[2]);
			transactions.add(transaction);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
