package org.swmaestro.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@DisplayName("MemberRestController 테스트")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@ActiveProfiles("local")
@Slf4j
class MemberRestControllerTest {

    @Autowired
    protected MockMvc mockMvc;

//    @Test
//    void create() {
//    }
//
//    @Test
//    @DisplayName("회원 정보 1명 정보 조회")
//    void read() {
//
//    }

    @Test
    void list() throws Exception {

        mockMvc
            .perform(
                get("/members")
                .contentType(MediaType.APPLICATION_JSON)
                // .cookie(cookieList.get(0), cookieList.get(1), cookieList.get(2))
            )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0]").exists())
            .andExpect(jsonPath("$[0].id", notNullValue()))
            .andExpect(jsonPath("$.length()", greaterThan(0))) // equalsTo, lessThan
            .andDo(print());
    }

//    @Test
//    void update() {
//    }
//
//    @Test
//    void delete() {
//    }

}