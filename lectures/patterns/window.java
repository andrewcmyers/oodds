class Window {

    enum State { OPENED, CLOSED, FULLSCREEN, MINIMIZED };

    private State state;

    public void open() {
        switch (state) {
            case OPENED:
            case FULLSCREEN:
            case CLOSED:
                break; // illegal
            case MINIMIZED:
                state = OPEN;
                openWindow();
                break;
    }

    public void close() {
        switch (state) {
            case OPEN:
            case FULLSCREEN:
                state = CLOSED;
                closeWindow();
                break;
            case MINIMIZED:
            case CLOSED:
                break; // illegal
        }
    }
    ...
}
