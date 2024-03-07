package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private  Owner owner;
    private List<Card> cards = new ArrayList<>();
    private Double cash;

    public Wallet(Owner owner, List<Card> cards, Double cash)  {
        this.owner = owner;
        this.cards = cards;
        this.cash = cash;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public  Double Withdraw(Double amount) {
        if (this.cash < amount) {
            System.out.println("SALDO KURANG");
            return  0.0;
        } else {
            this.cash -= amount;
            return amount;
        }
    }

    public Double  Deposit(Double amount) {
        this.cash += amount;
        return this.cash;
    }

    public void addCards(String bank,Integer accountNumber) {
        Card card = new Card();
        card.setNamaPemilik(this.owner.getNama());
        card.setNamaBank(bank);
        card.setNoRek(accountNumber);
        this.cards.add(card);
    }

    public void removeCard(Integer accountNumber) {
        for (Card card : cards) {
            if (card.getNoRek().equals(accountNumber)) {
                cards.remove(card);
                break;
            }
        }
    }
}
