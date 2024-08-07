package com.example.userprogress.service;

import com.example.userprogress.model.UserData;
import com.example.userprogress.repository.UserDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDataService {

    private final UserDataRepository userDataRepository;

    public UserDataService(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }

    public List<UserData> getAllUserData() {
        return userDataRepository.findAll();
    }

    public Optional<UserData> getUserDataById(Long id) {
        return userDataRepository.findById(id);
    }

    public void createUserData(UserData userData) {
        userDataRepository.save(userData);
    }

    public void updateUserData(UserData userDataDetails) {
        UserData userData = userDataRepository.findById(userDataDetails.getId()).orElseThrow();
        userData.setLastMonthExpenses(userDataDetails.getLastMonthExpenses());
        userData.setLastMonthSavings(userDataDetails.getLastMonthSavings());
        userDataRepository.save(userData);
    }

    public void deleteUserData(Long id) {
        userDataRepository.deleteById(id);
    }
}
