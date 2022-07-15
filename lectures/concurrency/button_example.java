Button b = ...
b.setOnAction(e -> {
   Thread t = new Thread() {
      public void run() {
         // do lots of work here!
      }
   };
   t.start();
});
