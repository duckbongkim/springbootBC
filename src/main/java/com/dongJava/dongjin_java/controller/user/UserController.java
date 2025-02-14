package com.dongJava.dongjin_java.controller.user;

import com.dongJava.dongjin_java.dto.user.request.UserCreateRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    private final JdbcTemplate jdbcTemplate;
    // sql 을 보낼수 있게 해주는 코드

    public UserController(JdbcTemplate jdbctemplate){
        this.jdbcTemplate = jdbctemplate;
        // 생성자 : JdbcTemplate 파라미터를 넣으면 자동으로 생성해주는 역할
    }
    // mysql 에 sql 문을 보내줄있는 코드

    @PostMapping("/user") // 매직 키워드
    // 어노테이션을 주면 라우터 기능을 실행
    public void saveUser(@RequestBody UserCreateRequest request){
        String sql = "INSERT INTO user(name, age) VALUE(?,?)";
        // sql문 을 db로 전송
        //saveUser(value)>>DTO UserCreateRequest
        jdbcTemplate.update(sql, request.getName(),request.getAge());
    }
    // 파라미터가 있는 dto로 가서 해당 매서드를 실행


}
