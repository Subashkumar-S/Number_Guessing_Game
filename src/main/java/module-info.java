module com.example.numberguessinggame {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.numberguessinggame to javafx.fxml;
    exports com.example.numberguessinggame;
}