public class Main extends Application implements Initializable {
    @FXML private Button theButton;
    @FXML private TextArea theTextArea;
    
    public static void main(final String[] args) {
        Application.launch(args);
    }
    
    @Override public void start(final Stage stage) {
        try {
            final URL r = getClass().getResource("simple.fxml");
            final Parent node = FXMLLoader.load(r);
            final Scene scene = new Scene(node);
            stage.setTitle("FXML demo");
            stage.setScene(scene);
            stage.sizeToScene();
            stage.show();
        } catch (final NullPointerException|IOException e) {
            System.out.println("Can't load FXML file.");
            try { stop(); } catch (final Exception e2) {}
        }
    }
}
