package statements;

import java.util.ArrayList;
import java.util.Date;

public class Transaction {
	private String bank;
	private String description;
	private long amount;
	private Date date;
	private ArrayList<String> tags;

	public Transaction(String bank, String desc, long amount, Date date,
			String tag) {

        if(tag==null){
            tag="uncatogerised";
        }

        tags = new ArrayList<String>();

		this.bank = bank;
		this.description = desc;
		this.amount = amount;
		this.date = date;
		this.tags.add(tag);
	}

	public String getBank() {
		return bank;
	}

	public String getDescription() {
		return description;
	}

	public long getAmount() {
		return amount;
	}

	public Date getDate() {
		return date;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void addTag(String tag) {
		if (!tags.contains(tag))
			tags.add(tag);
	}

	public void addTag(String[] tags) {
		for (String tag : tags) {
			this.addTag(tag);
		}
	}
}
