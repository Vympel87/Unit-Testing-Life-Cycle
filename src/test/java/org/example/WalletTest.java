package org.example;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WalletTest {
    private List<Card> initialCards;
    private Wallet wallet;

    @BeforeAll
    public void initClass() {
        System.out.println("Before All");
        initialCards = new ArrayList<>();
    }

    @BeforeEach
    public void initMethod() {
        System.out.println("Before Each");
        Owner owner = new Owner("Tanto", 30);
        wallet = new Wallet(owner, initialCards, 1000.0);
        wallet.addCards("BCA", 123456);
        wallet.addCards("BNI", 789012);
    }

    @Test
    public void testGetOwner() {
        assertEquals("Tanto", wallet.getOwner().getNama(), "Nama Pemilik Sesuai");
        assertEquals(30, wallet.getOwner().getUsia(), "Usia Sesuai");
    }

    @Test
    public void testGetCards() {
        assertNotNull(wallet.getCards(), "Ada Kartu");
        assertFalse(wallet.getCards().isEmpty(), "Daftar Tidak Kosong");
    }

    @Test
    public void testGetCash() {
        assertTrue(wallet.getCash() > 0, "Saldo Aman");
    }

    @Test
    public void testWithdrawSufficientBalance() {
        double amount = 500.0;
        double tempBalance = wallet.Withdraw(amount);
        assertEquals(500.0, tempBalance, "Tarik Tunai Berhasil");
        assertEquals(500.0, wallet.getCash(), "Saldo Penarikan Sesuai");
    }

    @Test
    public void testDeposit() {
        double amount = 500.0;
        double newBalance = wallet.Deposit(amount);
        assertEquals(1500.0, newBalance, "Deposit Berhasil");
        assertEquals(1500.0, wallet.getCash(), "Saldo Deposit Sesuai");
    }

    @Test
    public void testAddCards() {
        wallet.addCards("Mandiri", 654321);
        assertEquals(3, wallet.getCards().size(), "Kartu Berhasil Ditambahkan");
    }

    @Test
    public void testRemoveCard() {
        int accountNumberToRemove = 123456;
        wallet.removeCard(accountNumberToRemove);
        assertEquals(1, wallet.getCards().size(), "Kartu Berhasil Dihapus");
    }

    @AfterEach
    public void cleanMethod() {
        wallet.getCards().clear();
        wallet.setCash(1000.0);
        System.out.println("After Each");
    }

    @AfterAll
    public void cleanClass() {
        wallet = null;
        System.out.println("After All");
    }
}

