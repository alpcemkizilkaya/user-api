package com.bunny.userapi.service;

import com.bunny.userapi.domain.Users;
import com.bunny.userapi.repository.UsersRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UsersQueryServiceImpl implements UsersQueryService
{
    private final UsersRepository usersRepository;

    public UsersQueryServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Page<Users> listUsers(Pageable pageable) {
        return usersRepository.findAll(pageable);

    }
}
