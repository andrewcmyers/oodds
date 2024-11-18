class ButtonClicker implements EventHandler<ActionEvent> {
    void handle(ActionEvent e) {
        println("button clicked");
    }
};
...
b.setOnAction(new ButtonClicker());
