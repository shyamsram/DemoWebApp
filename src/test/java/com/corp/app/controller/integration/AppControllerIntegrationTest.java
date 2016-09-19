package com.corp.app.controller.integration;


import com.corp.app.entities.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URL;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppControllerIntegrationTest {

    @LocalServerPort
    private int port;

    private URL baseUrl;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        baseUrl = new URL("http://localhost:"+port+"/");
    }

    @Test
    public void testgetTransactionDetailForType() throws Exception {
        ResponseEntity<Transaction> response = template.getForEntity(baseUrl.toString()+"app/trandetail/bytype/Online",Transaction.class);
        assertThat(response.getBody().getTranId(),notNullValue());
    }
}
