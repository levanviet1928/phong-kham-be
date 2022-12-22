package com.team2.his.services.impl;

import com.team2.his.entitis.Account;
import com.team2.his.model.BaseModel;
import com.team2.his.model.ResponseModel;
import com.team2.his.model.auth.RegisterRequest;
import com.team2.his.repostiris.AccountRepository;
import com.team2.his.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AccountRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public ResponseModel register(RegisterRequest request) {
        try {
            ResponseModel model = new ResponseModel();
            String message = "";
            boolean existUserName = userRepository.existsByUserName(request.getUserName());
            if (existUserName) {
                message = "User name is exist, please input other user name ";
                BaseModel error = new BaseModel(HttpStatus.BAD_REQUEST.value(), message);
                model.setData(error);
                model.setDescription(message);
                model.setResponseStatus(HttpStatus.BAD_REQUEST);
                return model;
            }
            // check account exist
            Account newAccount = new Account();
            newAccount.setPassword(passwordEncoder.encode(request.getPassword()));
           newAccount.setUserName(request.getUserName());
            userRepository.save(newAccount);
            message = "Created account success!";
            BaseModel success = new BaseModel(HttpStatus.OK.value(), message);
            model.setData(success);
            model.setDescription(message);
            model.setResponseStatus(HttpStatus.OK);
            return model;
        } catch (Exception e) {
            BaseModel error = new BaseModel(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Server error!");
            ResponseModel model = new ResponseModel();
            model.setData(error);
            model.setDescription("Server error!");
            model.setResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return model;
        }
    }

    @Override
    public Account getAccountInfoByLoginId(String loginId) {
        return userRepository.findByUserName(loginId).orElse(null);
    }
}
