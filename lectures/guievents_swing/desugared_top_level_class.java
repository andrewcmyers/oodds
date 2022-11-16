class ButtonClicker implements ActionListener {
    void handle(ActionEvent e) {
        print("button clicked");
    }
};
...
b.addActionListener(new ButtonClicker());
