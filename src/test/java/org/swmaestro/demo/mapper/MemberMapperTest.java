package org.swmaestro.demo.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.swmaestro.demo.model.Member;
import org.swmaestro.demo.model.MemberCase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
@Slf4j
class MemberMapperTest {

    @Mock
    private MemberMapper memberMapper;

    private Member param;
    private Member testMember;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        MemberCase memberCase = new MemberCase();
        param = memberCase.getParam();
        testMember = memberCase.getTestCase();
        log.info("param={}, testMember={}", param, testMember);
    }

//    @Test
//    @DisplayName("Member 등록")
//    void create() {
//
//    }

    @Test
    @DisplayName("Member 1명 정보 조회 테스트")
    void read() {

        // given
        Member givenMember = memberMapper.read(param);
        given(givenMember).willReturn(testMember);

        // when
        Member whenMember = memberMapper.read(param);
        log.info("whenMember={}", whenMember);

        // then
        then(memberMapper).should().read(param);
        assertThat(whenMember.getId()).isEqualTo(param.getId());
        assertThat(whenMember.getPassword()).isEqualTo(testMember.getPassword());
        assertThat(whenMember.getName()).isEqualTo(testMember.getName());
        assertThat(whenMember.getEmail()).isEqualTo(testMember.getEmail());
        assertThat(whenMember.getPhone()).isEqualTo(testMember.getPhone());
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