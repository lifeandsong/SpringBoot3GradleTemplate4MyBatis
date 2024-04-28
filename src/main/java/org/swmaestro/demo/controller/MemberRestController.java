package org.swmaestro.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.swmaestro.demo.config.Auth;
import org.swmaestro.demo.model.Member;
import org.swmaestro.demo.service.MemberService;
import org.swmaestro.demo.util.Sha512Encryptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 회원 정보를 CRUD 하는 RESTful API를 제공하는 RestController
 * - MyBatis
 *
 * @since   2022-06-29
 * @author  ywkim
 */
@RestController
@RequestMapping("/mybatis/members")
@RequiredArgsConstructor
@Slf4j
public class MemberRestController extends BaseRestController {
    private final MemberService memberService;
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Member member) {

        // 1. Validation
        if (member == null) {
            log.warn("create: Fail to create a new member; member=null, createdCount=0");
            return ResponseEntity.badRequest().build();
        }

        log.info("create: member={}", member);
        if (! StringUtils.hasLength(member.getId())) {
            log.warn("Fail to create a new member; createdCount=0");
            return ResponseEntity.badRequest().build();
        }

        // 2. Business Logic
        Sha512Encryptor sha512 = new Sha512Encryptor();
        member.setPassword(sha512.encrypt(member.getPassword()));
        int createdCount = memberService.create(member);

        // 3. Make Response
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("createdCount", createdCount);
        log.info("resultMap={}", resultMap);
        return ResponseEntity.ok(resultMap);
    }

    @GetMapping("/{id}")
    @Auth
    public ResponseEntity<?> read(@PathVariable String id) {
        log.info("read: id={}", id);

        // 1. Validation
        if (! StringUtils.hasLength(id)) {
            log.warn("Fail to read a member; member=null");
            return ResponseEntity.badRequest().build();
        }

        // 2. Business Logic
        Member param = new Member();
        param.setId(id);
        log.info("param={}", param);

        Member member = memberService.read(param);
        if (member == null) {
            log.warn("Fail to read a member; member=null");
            return ResponseEntity.badRequest().build();
        }

        // 3. Make Response
        log.info("member={}", member);
        return ResponseEntity.ok(member);
    }

    @GetMapping("")
    @Auth
    public ResponseEntity<?> list(@RequestParam(required = false) Map<String, Object> param) {
        if (param == null)
            param = new HashMap<String, Object>();

        log.info("list; param={}");

        // 1. Validation

        // 2. Business Logic
        Member member = new Member();
        if (param != null) {
            if (param.get("name") != null)
                member.setName(String.valueOf(param.get("name")));

            if (param.get("email") != null)
                member.setEmail(String.valueOf(param.get("email")));

            if (param.get("phone") != null)
                member.setPhone(String.valueOf(param.get("phone")));
        }

        List<Member> list = memberService.list(member);
        if (list == null)
            list = new ArrayList<Member>();

        // 3. Make Response
        log.info("list.size={}", list.size());
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    @Auth
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Member member) {
        if (member == null)
            member = new Member();

        log.info("update: id={}, member={}", id, member.toString());

        // 1. Validation
        if (! StringUtils.hasLength(id)) {
            log.warn("Fail to update a member; updatedCount=0");
            return ResponseEntity.badRequest().build();
        }

        // 2. Business Logic
        member.setId(id);
        int updatedCount = memberService.update(member);

        // 3. Make Response
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("updatedCount", updatedCount);
        log.info("resultMap={}", resultMap);
        return ResponseEntity.ok(resultMap);
    }

    @DeleteMapping("/{id}")
    @Auth
    public ResponseEntity<?> delete(@PathVariable String id) {
        log.info("update: id={}", id);

        // 1. Validation
        if (! StringUtils.hasLength(id)) {
            log.warn("Fail to delete a member; deletedCount=0");
            return ResponseEntity.badRequest().build();
        }

        // 2. Business Logic
        int deletedCount = memberService.delete(id);

        // 3. Make Response
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("deletedCount", deletedCount);
        log.info("resultMap={}", resultMap);
        return ResponseEntity.ok(resultMap);
    }

}
