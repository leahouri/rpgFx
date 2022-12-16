module com.example.rpgfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rpgfx to javafx.fxml;
    exports com.example.rpgfx;
}