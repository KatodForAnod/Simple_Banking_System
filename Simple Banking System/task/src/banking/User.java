package banking;

public class User {
    private final String numberFfCard;
    private double balance;
    private String password;

    public User(String password, String numberFfCard) {
        this.password = password;
        this.numberFfCard = numberFfCard;
        balance = 0;
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
