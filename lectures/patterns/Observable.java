interface Observable<T> {
    void registerObserver(Observer<T> observer);
}
