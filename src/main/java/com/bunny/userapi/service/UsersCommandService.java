package com.bunny.userapi.service;

import com.bunny.userapi.domain.Users;
import com.bunny.userapi.dto.UsersDTO;

public interface UsersCommandService {
    public Users updateUser(Users user);
    public void deleteUser(Long id);
}
