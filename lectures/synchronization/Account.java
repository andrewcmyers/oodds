class Account {
    synchronized void withdraw(int n) throws InsufficientFunds {
        if (balance < n) throw new InsufficientFunds();
        balance -= n;
    }
    synchronized void deposit(int n) { balance += n; }
}
