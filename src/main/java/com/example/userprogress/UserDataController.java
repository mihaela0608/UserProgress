package com.example.userprogress;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/userdata")
public class UserDataController {

    private final UserDataService userDataService;

    public UserDataController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @GetMapping
    public ResponseEntity<List<UserData>> getAllUserData() {
        List<UserData> allUserData = userDataService.getAllUserData();
        return new ResponseEntity<>(allUserData, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserData> getUserDataById(@PathVariable Long id) {
        Optional<UserData> userData = userDataService.getUserDataById(id);
        return userData.map(data -> new ResponseEntity<>(data, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUserData(@RequestBody UserData userData) {
        userDataService.createUserData(userData);
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateUserData(@RequestBody UserData userDataDetails) {
        userDataService.updateUserData(userDataDetails);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserData(@PathVariable Long id) {
        userDataService.deleteUserData(id);
    }
}
