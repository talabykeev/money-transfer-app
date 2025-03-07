package com.tal.moneytransferapp.unit;

import com.tal.moneytransferapp.UserService;
import com.tal.moneytransferapp.model.User;
import com.tal.moneytransferapp.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

public class UserServiceTestCorrectVersion {

    private UserRepository userRepository = Mockito.mock(UserRepository.class);

    private UserService userService;

    @Before
    public void initUserService() {
        userService = new UserService(userRepository);
    }

    @Test
    public void testFetchAll() {

        List<User> userList = new ArrayList<>();
        userList.add(new User("Askar", "Akaev"));

        when(userRepository.findAll()).thenReturn(userList);
        assertThat(userService.fetchAllUsers()).isNotEmpty();
    }
}
