package sbwebtry.tliastry.controller;

import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sbwebtry.tliastry.pojo.Emp;
import sbwebtry.tliastry.pojo.Result;
import sbwebtry.tliastry.service.Empservice;
import sbwebtry.tliastry.utils.JwtUtils;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@WebFilter(urlPatterns = "/*")
public class Logincontroller {

    @Autowired
    private Empservice empservice;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("员工登录{}",emp);
        Emp e = empservice.login(emp);

        //判断数据是否存在，并将数据封装进去
        if(e != null){
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",e.getId());
            claims.put("name",e.getName());
            claims.put("username",e.getUsername());

            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }
}
