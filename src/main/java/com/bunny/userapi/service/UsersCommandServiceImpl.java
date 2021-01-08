package com.bunny.userapi.service;

import com.bunny.userapi.domain.Users;
import com.bunny.userapi.dto.UsersDTO;
import com.bunny.userapi.repository.UsersRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UsersCommandServiceImpl implements UsersCommandService
{
    private final UsersRepository usersRepository;

    public UsersCommandServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Users updateUser(Users user) {
        return usersRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        usersRepository.delete(new Users(id));
    }
}
