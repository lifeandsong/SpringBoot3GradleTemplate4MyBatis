package org.swmaestro.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.swmaestro.demo.mapper.MemberMapper;
import org.swmaestro.demo.model.Member;

import java.util.ArrayList;
import java.util.List;

/**
 * Member Service
 *
 * @since	2022-06-29
 * @author	ywkim
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService extends BaseService {

    private final MemberMapper memberMapper;

    public int create(Member member) {
        log.info("create; member={}", member);

        int createdCount = 0;

        if (member == null) {
            log.warn("createdCount={}", createdCount);
            return createdCount;
        }

        try {
            createdCount = memberMapper.create(member);
        } catch(Exception e) {
            log.error(e.getMessage());
        }

        if (createdCount < 1)
            log.warn("createdCount={}", createdCount);
        else
            log.info("createdCount={}", createdCount);

        return createdCount;
    }

    public Member read(Member param) {
        log.info("read; param={}", param);

        Member member = memberMapper.read(param);
        if (member == null)
            member = new Member();

        log.info("member={}", member);

        return member;
    }

    public List<Member> list(Member member) {
        log.info("list; member={}", member);

        if (member == null) {
            log.warn("list.size=0");
            return new ArrayList<Member>();
        }

        List<Member> list = null;


        try {
            list = memberMapper.list(member);
        } catch(Exception e) {
            log.error(e.getMessage());
        }

        if (list == null)
            list = new ArrayList<Member>();

        log.info("list.size={}", list);

        return list;
    }

    public int update(Member member) {
        log.info("update; member={}", member);

        int updatedCount = 0;

        if (member == null) {
            log.warn("updatedCount={}", updatedCount);
            return updatedCount;
        }

        try {
            updatedCount = memberMapper.update(member);
        } catch(Exception e) {
            log.error(e.getMessage());
        }

        if (updatedCount < 1)
            log.warn("updatedCount={}", updatedCount);
        else
            log.info("updatedCount={}", updatedCount);

        return updatedCount;
    }

    public int delete(String id) {
        log.info("update; id={}", id);

        int deletedCount = 0;

        try {
            deletedCount = memberMapper.delete(id);
        } catch(Exception e) {
            log.error(e.getMessage());
        }

        if (deletedCount < 1)
            log.warn("deletedCount={}", deletedCount);
        else
            log.info("deletedCount={}", deletedCount);

        return deletedCount;
    }

}
