package org.xpef.server.service;

import org.xpef.server.model.po.User;

public interface UserService {

    public User getUserById(Integer id);

    public User getUserByEmail(String email);

    public User getUserByName(String name);

    public Boolean updateUser(User user);
}
