module org.example.csc311_module03_assignment {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.csc311_module03_assignment to javafx.fxml;
    exports org.example.csc311_module03_assignment;
}