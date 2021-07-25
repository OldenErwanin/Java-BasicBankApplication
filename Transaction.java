import java.util.Date;

public class Transaction {
    private final String tType;
    private final int tAmount;
    private final Date tDate;

    public Transaction(String tType, int tAmount) {
        this.tType = tType;
        this.tAmount = tAmount;
        this.tDate = new Date(System.currentTimeMillis());
    }

    public String gettType() {
        return tType;
    }

    public int gettAmount() {
        return tAmount;
    }

    public Date gettDate() {
        return tDate;
    }
}
