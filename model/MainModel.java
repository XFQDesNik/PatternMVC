package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;
import com.javarush.task.task36.task3608.model.ModelData;
import com.javarush.task.task36.task3608.bean.User;

import java.util.List;

public class MainModel implements Model {
    private UserService userService = new UserServiceImpl();
    private ModelData modelData = new ModelData();
    
    @Override
    public void loadUsers() {
       // List<User> list = userService.getUsersBetweenLevels(1, 100);
       //modelData.setUsers(list);
       //modelData.setDisplayDeletedUserList(false);
       
       modelData.setDisplayDeletedUserList(false);
        modelData.setUsers(getAllUsers());
    }
    
    public void loadDeletedUsers() {
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
        modelData.setDisplayDeletedUserList(true);
    }
    
    @Override
    public ModelData getModelData() {
        return modelData;
    }
    
    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }
    
    public void deleteUserById(long id) {
        userService.deleteUser(id);
        modelData.setUsers(getAllUsers());
        
    }
    
    private List<User> getAllUsers() {
        return userService.filterOnlyActiveUsers(userService.getUsersBetweenLevels(1, 100));
    }
    
    public void changeUserData(String name, long id, int level)
    {
        userService.createOrUpdateUser(name,id,level);
        loadUsers();
    }
}
