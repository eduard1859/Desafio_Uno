package com.desafiouno.web.rest;

import com.desafiouno.DesafioApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Test class for the DesafioResource REST controller.
 *
 * @see DesafioResource
 */
@SpringBootTest(classes = DesafioApp.class)
public class DesafioResourceIT {

    private MockMvc restMockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    /**
     * Test invocaGDD
     */
    @Test
    public void testInvocaGDD() throws Exception {
        restMockMvc.perform(post("/api/desafio/invoca-gdd"))
            .andExpect(status().isOk());
    }

    /**
     * Test nova
     */
    @Test
    public void testNova() throws Exception {
        restMockMvc.perform(get("/api/desafio/nova"))
            .andExpect(status().isOk());
    }
}
