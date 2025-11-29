if (i > j) {
    // swap i and j if out of order
    int tmp = i; i = j; j = tmp;
}
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
