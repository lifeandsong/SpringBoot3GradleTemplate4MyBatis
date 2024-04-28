package org.swmaestro.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.swmaestro.demo.model.Member;
import org.swmaestro.demo.model.MemberCase;

@ExtendWith(MockitoExtension.class)
@Slf4j
class MemberServiceTest {

    @Mock
    private MemberService memberService;

    private Member param;
    private Member testMember;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        MemberCase userCase = new MemberCase();
        param = userCase.getParam();
        testMember = userCase.getTestCase();
        log.info("param={}, testMember={}", param, testMember);
    }

//    @Test
//    void create() {
//    }

    @Test
    @DisplayName("회원 1명의 정보 조회 테스트")
    void read() {

        // given
        Member givenMember = memberService.read(param);
        given(givenMember).willReturn(testMember);

        // when
        Member whenMember = memberService.read(param);

        // then
        then(memberService).should().read(param);

        Assertions.assertThat(whenMember.getId()).isEqualTo(testMember.getId());
        Assertions.assertThat(whenMember.getPassword()).isEqualTo(testMember.getPassword());
        Assertions.assertThat(whenMember.getName()).isEqualTo(testMember.getName());
        Assertions.assertThat(whenMember.getEmail()).isEqualTo(testMember.getEmail());
        Assertions.assertThat(whenMember.getPhone()).isEqualTo(testMember.getPhone());
    }

//    @Test
//    void list() {
//    }
//
//    @Test
//    void update() {
//    }
//
//    @Test
//    void delete() {
//    }

}