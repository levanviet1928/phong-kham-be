package com.team2.his.services.impl;

import com.team2.his.repostiris.AccountRepository;
import com.team2.his.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final AccountRepository userRepository;

}
