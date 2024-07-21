package com.example.userprogress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDataService {

    @Autowired
    private UserDataRepository userDataRepository;

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
