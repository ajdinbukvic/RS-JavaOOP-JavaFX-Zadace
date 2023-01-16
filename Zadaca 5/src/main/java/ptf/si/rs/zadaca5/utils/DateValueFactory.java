package ptf.si.rs.zadaca5.utils;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateValueFactory<T> implements Callback<TableColumn<T, LocalDateTime>, TableCell<T, LocalDateTime>> {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy', u 'hh:mm");

    @Override
    public TableCell<T, LocalDateTime> call(TableColumn<T, LocalDateTime> param) {
        return new TableCell<>(){
            @Override
            protected void updateItem(LocalDateTime item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) setText("");
                else setText(DATE_FORMAT.format(item));
            }
        };
    }
}
