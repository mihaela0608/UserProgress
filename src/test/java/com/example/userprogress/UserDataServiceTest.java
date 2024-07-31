package com.example.userprogress;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@SpringBootTest
@Transactional
public class UserDataServiceTest {

    @Autowired
    private UserDataService userDataService;

    @Autowired
    private UserDataRepository userDataRepository;

    private UserData testUserData;

    @BeforeEach
    public void setUp() {
        userDataRepository.deleteAll();

        testUserData = new UserData();
        testUserData.setId(1L);
        testUserData.setLastMonthExpenses(BigDecimal.valueOf(1000.0));
        testUserData.setLastMonthSavings(BigDecimal.valueOf(500.0));
        userDataRepository.save(testUserData);
    }

    @Test
    public void testGetAllUserData() {
        List<UserData> userDataList = userDataService.getAllUserData();
        Assertions.assertFalse(userDataList.isEmpty());
        Assertions.assertTrue(userDataList.contains(testUserData));
    }

    @Test
    public void testGetUserDataById() {
        Optional<UserData> userData = userDataService.getUserDataById(testUserData.getId());
        Assertions.assertTrue(userData.isPresent());
    }


    @Test
    public void testUpdateUserData() {
        UserData updatedUserData = new UserData();
        updatedUserData.setId(testUserData.getId());
        updatedUserData.setLastMonthExpenses(BigDecimal.valueOf(1500.0));
        updatedUserData.setLastMonthSavings(BigDecimal.valueOf(700.0));

        userDataService.updateUserData(updatedUserData);

        Optional<UserData> userData = userDataService.getUserDataById(testUserData.getId());
        Assertions.assertTrue(userData.isPresent());
        Assertions.assertEquals(userData.get().getLastMonthExpenses(), BigDecimal.valueOf(1500.0));
        Assertions.assertEquals(userData.get().getLastMonthSavings(), BigDecimal.valueOf(700.0));
    }

    @Test
    public void testDeleteUserData() {
        userDataService.deleteUserData(testUserData.getId());

        Optional<UserData> userData = userDataService.getUserDataById(testUserData.getId());
        Assertions.assertTrue(userData.isEmpty());
    }
}
