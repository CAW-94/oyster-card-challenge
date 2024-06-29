

import java.math.BigDecimal;

public class Card {

    BigDecimal balance  = BigDecimal.ZERO;

    public Card(){}

    public Card(BigDecimal balance){
        this.balance = balance;
    }

    public BigDecimal getBalance(){
        return this.balance;
    }

    public void checkBalance(){
        System.out.println("Your balance is: £" + this.balance.setScale(2) + "\n");
    }

    public void addBalance( BigDecimal credit){
        this.balance = this.balance.add(credit);
    }

    private Boolean canRemoveBalance(BigDecimal fare){
        return this.balance.compareTo(fare)>= 0;
    }

    public void checkBalance(BigDecimal fare){
        if(!canRemoveBalance(fare)){throw new IllegalArgumentException("Balance: " + this.balance.setScale(2) + " Fare: " + fare.setScale(2));}
        }

    public void removeBalance( BigDecimal fare){
        this.balance = this.balance.subtract(fare);
    }
}

