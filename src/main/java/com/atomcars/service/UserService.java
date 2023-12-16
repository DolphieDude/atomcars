package com.atomcars.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.IllegalCharsetNameException;

@Service
@AllArgsConstructor
public class UserService {

//    private final UnitOfWork unitOfWork;
//
//    public void makeUserPremium(User user) {
//        unitOfWork.begin();
//        try {
//            user.setName("PREMIUM " + user.getName());
//            if (!(user instanceof CompleteUser)) {
//                throw new IllegalStateException("User must be complete");
//            }
//
//            unitOfWork.registerDirty(user);
//
//            unitOfWork.save();
//        } catch (Exception e) {
//            unitOfWork.dispose();
//            e.printStackTrace();
//        }
//    }
}
