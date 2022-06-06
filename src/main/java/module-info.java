module com.example.royallineandco {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires jfreechart;

    opens com.example.royallineandco to javafx.fxml;
    exports com.example.royallineandco;
}