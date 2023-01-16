module ptf.si.rs.zadaca5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;

    requires org.hibernate.commons.annotations;
    requires org.hibernate.orm.core;
    requires java.persistence;
    opens ptf.si.rs.zadaca5.models to org.hibernate.orm.core;


    opens ptf.si.rs.zadaca5 to javafx.fxml;
    exports ptf.si.rs.zadaca5;
    exports ptf.si.rs.zadaca5.controllers;
    exports ptf.si.rs.zadaca5.models;
    exports ptf.si.rs.zadaca5.repository;
    exports ptf.si.rs.zadaca5.utils;
}