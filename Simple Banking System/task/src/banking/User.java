package banking;

public class User {
    private final String numberFfCard;
    private double balance;
    private String password;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User(String password, String numberFfCard) {
        this.password = password;
        this.numberFfCard = numberFfCard;
        balance = 0;
        id = 0;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getNumberFfCard() {
        return numberFfCard;
    }

    public double getBalance() {
        return balance;
    }
}
