package org.swmaestro.demo.model;

import org.swmaestro.demo.util.Sha512Encryptor;

public class MemberCase {

    public Member getParam() {
        Member param = new Member();
        param.setId("test");
        return param;
    }

    public Member getTestCase() {
        Sha512Encryptor sha512 = new Sha512Encryptor();
        String password = sha512.encrypt("test1234");

        Member member = new Member();
        member.setId("test");
        member.setPassword(password);
        member.setName("테스터");
        member.setEmail("test@company.com");
        member.setPhone("010-2345-6789");
        return member;
    }

}
