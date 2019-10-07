package com.tal.moneytransferapp;

import com.tal.moneytransferapp.model.User;
import com.tal.moneytransferapp.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repository;

    @Test
    public void testFindByFirstName() throws Exception {
        User mockUser = new User();
        mockUser.setFirstName("Chyngyz");
        mockUser.setLastName("Aitmatov");
        this.entityManager.persist(mockUser);

        Iterable<User> users = this.repository.findByFirstName("Chyngyz");

        List<User> userList= new ArrayList<>();

        users.forEach(userList::add);

        assertThat(userList).isNotEmpty();
        assertThat(userList).contains(mockUser);

        User user = userList.get(0);

        assertThat(user.getLastName()).isEqualTo("Aitmatov");
        assertThat(user.getFirstName()).isEqualTo("Chyngyz");
    }
}