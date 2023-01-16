module ptf.si.rs.zadaca4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ptf.si.rs.zadaca4 to javafx.fxml;
    exports ptf.si.rs.zadaca4;
    exports ptf.si.rs.zadaca4.controllers;
    exports ptf.si.rs.zadaca4.models;
    exports ptf.si.rs.zadaca4.repository;
    exports ptf.si.rs.zadaca4.utils;
}