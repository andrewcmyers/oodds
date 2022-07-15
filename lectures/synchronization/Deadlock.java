Account[] accounts = new Account[N];

synchronized (accounts[i]) {
    synchronized (accounts[j]) {
        try {
            accounts[i].withdraw(1); withdrawn++;
            accounts[j].withdraw(1); withdrawn++;
            accounts[k].deposit(withdrawn);
        } catch (InsufficientFunds exc) {
            if (withdrawn == 1) accounts[i].deposit(1);
        }
    }
}
