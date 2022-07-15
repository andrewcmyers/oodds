if (i > j) { int tmp = i; i = j; j = tmp; } // swap if out of order
int withdrawn = 0;
synchronized (accounts[i]) {
    synchronized (accounts[j]) {
        try {
            accounts[i].withdraw(1); withdrawn++;
            accounts[j].withdraw(1); withdrawn++;
        } catch (InsufficientFunds exc) {
            if (withdrawn == 1) accounts[i].deposit(1);
        }
    }
}
if (withdrawn == 2) accounts[k].deposit(withdrawn);
