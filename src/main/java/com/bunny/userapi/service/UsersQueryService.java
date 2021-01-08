package com.bunny.userapi.service;

import com.bunny.userapi.domain.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsersQueryService {
    public Page<Users> listUsers(Pageable pageable);
}
