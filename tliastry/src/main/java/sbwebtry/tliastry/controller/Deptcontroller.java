package sbwebtry.tliastry.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sbwebtry.tliastry.pojo.Dept;
import sbwebtry.tliastry.pojo.Result;
import sbwebtry.tliastry.service.Deptservice;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
/*使用@RestController注解的控制器会自动将方法返回的对象转换为JSON格式。
在这个例子中，虽然方法返回的是Result对象，
但Spring会将Result对象转换为JSON格式并返回给前端。*/
public class Deptcontroller {

    @Autowired
    private Deptservice deptservice;

    @GetMapping
    public Result getall(){
        log.info("全部读取");
        List<Dept> now = deptservice.getall();
        return Result.success(now);
    }

    @GetMapping("/{id}")
    public Result getbyid(@PathVariable Integer id){
        log.info("读取id为{}的数据",id);
        Dept now = deptservice.getbyid(id);
        return Result.success(now);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) throws Exception {
        log.info("删除id为{}的数据",id);
        deptservice.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("添加{}的数据",dept.getName());
        deptservice.add(dept);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("更新id为{}的部门名称变为{}",dept.getId(),dept.getName());
        deptservice.update(dept);
        return Result.success();
    }
}
