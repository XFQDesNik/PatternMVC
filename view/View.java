package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.model.ModelData;

import com.javarush.task.task36.task3608.controller.Controller;

public interface View {
    void refresh(ModelData modelData);
    void setController(Controller controller);
}
