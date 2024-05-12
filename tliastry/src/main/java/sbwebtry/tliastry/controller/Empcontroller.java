package sbwebtry.tliastry.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import sbwebtry.tliastry.pojo.Emp;
import sbwebtry.tliastry.pojo.PageBean;
import sbwebtry.tliastry.pojo.Result;
import sbwebtry.tliastry.service.Empservice;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequestMapping("/emps")
@RestController
public class Empcontroller {

    @Autowired
    private Empservice empservice;

    @GetMapping
    public Result getall(@RequestParam(defaultValue = "1") Integer page,
                         @RequestParam(defaultValue = "10") Integer pageSize,
                         Short gender, String name,
                         @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                         @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("读取第{}页，每页{}条数据,{}{}{}{}",page,pageSize,gender,name,begin,end);
        PageBean now = empservice.getall(page,pageSize,name,gender,begin,end);
        return Result.success(now);
    }

    @GetMapping("/{id}")
    public Result getbyid(@PathVariable Integer id){
        log.info("读取id为{}的数据",id);
        Emp emp = empservice.getbyid(id);
        return Result.success(emp);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){//这个忘加@PathVariable找了好久
        log.info("删除id为{}",ids);
        empservice.delete(ids);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Emp emp){//这个忘加@RequestBody找了好久
        log.info("添加{}",emp);
        empservice.add(emp);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("更新id为{}",emp.getId());
        empservice.update(emp);
        return Result.success();
    }
}
