package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class GuildMaster extends User implements Management{
    public GuildMaster(){}

    @Override
    public void create(TableView tableView, Object object, MANAGE mode) {

    }

    @Override
    public void read(TableView tableView, Object object, MANAGE mode) {

    }

    @Override
    public void update(TableView tableView, Object object, MANAGE mode) {

    }

    @Override
    public void delete(TableView tableView, Object object, MANAGE mode) {

    }

    @Override
    public Object get(TableView tableView) {
        return null;
    }
}
