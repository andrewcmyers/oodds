class ButtonClicker extends EventHandler<ActionEvent> {
    void handle(ActionEvent e) {
        print("button clicked");
    }
};
...
b.setOnAction(new ButtonClicker());
