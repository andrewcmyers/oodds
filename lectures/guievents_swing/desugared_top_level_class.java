class ButtonClicker extends ActionListener {
    void handle(ActionEvent e) {
        print("button clicked");
    }
};
...
b.addActionListener(new ButtonClicker());
