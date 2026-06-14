package org.example.banking_account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BankingAccountTest {

    private BankingAccount account;
    private ByteArrayOutputStream output;

    @BeforeEach
    void setUp() {
        account = new BankingAccount("Mateusz", "12345", 100.0);

        // Przechwytywanie System.out
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    // -----------------------------
    // deposit()
    // -----------------------------
    @Test
    void testDepositPositiveAmount() {
        account.deposit(50);

        assertEquals(150.0, account.getBalance());
        assertTrue(output.toString().contains("Deposit successful!"));
    }

    @Test
    void testDepositNegativeAmount() {
        account.deposit(-20);

        assertEquals(100.0, account.getBalance());
        assertTrue(output.toString().contains("Amount must be positive."));
    }

    // -----------------------------
    // withdraw()
    // -----------------------------
    @Test
    void testWithdrawSuccess() {
        account.withdraw(40);

        assertEquals(60.0, account.getBalance());
        assertTrue(output.toString().contains("Withdraw successful!"));
    }

    @Test
    void testWithdrawInsufficientFunds() {
        account.withdraw(200);

        assertEquals(100.0, account.getBalance());
        assertTrue(output.toString().contains("Insufficient funds."));
    }

    @Test
    void testWithdrawNegativeAmount() {
        account.withdraw(-10);

        assertEquals(100.0, account.getBalance());
        assertTrue(output.toString().contains("Only positive amount acceptable."));
    }

    // -----------------------------
    // getBalance()
    // -----------------------------
    @Test
    void testGetBalance() {
        assertEquals(100.0, account.getBalance());
    }

    // -----------------------------
    // displayInfo()
    // -----------------------------
    @Test
    void testDisplayInfo() {
        account.displayInfo();

        String out = output.toString();
        assertTrue(out.contains("Account Holder: Mateusz"));
        assertTrue(out.contains("Account Number: 12345"));
        assertTrue(out.contains("Balance: 100.00"));
    }
}
