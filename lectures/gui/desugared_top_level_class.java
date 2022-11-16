class ButtonClicker implements EventHandler<ActionEvent> {
    void handle(ActionEvent e) {
        print("button clicked");
    }
};
...
b.setOnAction(new ButtonClicker());
