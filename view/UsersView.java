package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;
import com.javarush.task.task36.task3608.bean.User;
import java.util.List;

public class UsersView implements View {
    private Controller controller;
    
    public void setController(Controller controller) {
        this.controller = controller;
    }
    
    public void refresh(ModelData modelData) {
        if(!modelData.isDisplayDeletedUserList()) {
            System.out.println("All users:");
        }else {
            System.out.println("All deleted users:");
        }
            List<User> list = modelData.getUsers();
            for (int i = 0; i < list.size(); i++) {
                System.out.print("\t");
                System.out.println(list.get(i));
            }
            System.out.println("===================================================");


    }
    
    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }
    
    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }
    
    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }
}
