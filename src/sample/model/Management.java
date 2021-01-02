package sample.model;

import javafx.scene.control.TableView;

public interface Management <T>{
    public  enum MANAGE{JOB,QUEST,MEMBER,HERB,GOODS,MONSTER}
    void create(TableView<T> tableView,T object, MANAGE mode);
}
