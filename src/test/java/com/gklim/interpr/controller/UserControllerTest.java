package com.gklim.interpr.controller;

import com.gklim.interpr.models.User;
import com.gklim.interpr.repositories.UserRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
@ActiveProfiles(profiles = "test")
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserRepository repository;

    @Test
    @SneakyThrows
    public void testFindAllUsers() {
        User user = new User(null,
                "test_name",
                "test_surname",
                "ttt@test.ru",
                "test_password");
        User saved = repository.save(user);
        mvc.perform(MockMvcRequestBuilders.get("/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].firstName", is(saved.getFirstName())));
    }

    @Test
    @SneakyThrows
    public void testFindUserById() {
        User user = new User(null,
                "test_name",
                "test_surname",
                "ttt@test.ru",
                "test_password");
        User saved = repository.save(user);
        mvc.perform(MockMvcRequestBuilders.get("/users/" + saved.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is(saved.getFirstName())));
    }
}
