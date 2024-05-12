package sbwebtry.tliastry.service;

import org.springframework.format.annotation.DateTimeFormat;
import sbwebtry.tliastry.pojo.Emp;
import sbwebtry.tliastry.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface Empservice {

    PageBean getall(Integer page,Integer pagesize,String name,Short gender ,LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void add(Emp emp);

    Emp getbyid(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);
}
