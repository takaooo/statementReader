package test;

        import java.util.ArrayList;

        import org.junit.Test;

        import statements.AmexStatementReader;
        import statements.StatementReader;
        import statements.Transaction;

public class testAmexReader {

    @Test
    public void readAmexTest() {
        String directory = "/Users/takao/Documents/workspace/statements/resources/";
        String amex = "amex.csv";

        StatementReader reader = new AmexStatementReader();
        ArrayList<Transaction> testList = reader
                .readStatement(directory + amex);
        System.out.println(testList.get(0).getAmount());

    }
}
