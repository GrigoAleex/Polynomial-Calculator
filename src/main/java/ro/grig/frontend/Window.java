package ro.grig.frontend;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ro.grig.frontend.exceptions.ViewNotFoundException;
import ro.grig.frontend.exceptions.WindowUninitializedException;

import java.io.IOException;
import java.net.URL;

public class Window {
    private final Stage stage;
    private static Window instance;

    public Window(Stage stage) {
        stage.setTitle("calculatordepolinoame.ro");
        stage.show();
        this.stage = stage;
        instance = this;
    }

    public static Window getInstance() throws WindowUninitializedException {
        if (instance == null) throw new WindowUninitializedException();
        return instance;
    }

    public static void setView(String view) throws ViewNotFoundException, WindowUninitializedException, IOException {
        Window window = getInstance();

        URL viewPath = window.getClass().getResource(view + ".fxml");

        if (viewPath == null) throw new ViewNotFoundException();

        window.stage.setScene(new Scene(FXMLLoader.load(viewPath)));
    }
}
