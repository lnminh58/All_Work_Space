package com.lnminh.service.user;

import com.lnminh.dao.UsersRepository;
import com.lnminh.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public Users getUserByUsername(String username) {
        return usersRepository.findOne(username);
    }
}
