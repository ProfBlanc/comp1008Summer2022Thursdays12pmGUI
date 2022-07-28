module ca.georgiancollege.cppr.comp1008.comp1008summer2022thursdays12pmgui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens ca.georgiancollege.cppr.comp1008.comp1008summer2022thursdays12pmgui to javafx.fxml;
    exports ca.georgiancollege.cppr.comp1008.comp1008summer2022thursdays12pmgui;
}