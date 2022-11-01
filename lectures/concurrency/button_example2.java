Button b = ...
b.setOnAction(e -> new Thread(() -> {
                      // do lots of work here!
                   }).start());
