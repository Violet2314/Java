package sbwebtry.tliastry.service.imp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbwebtry.tliastry.mapper.Empmapper;
import sbwebtry.tliastry.pojo.Emp;
import sbwebtry.tliastry.pojo.PageBean;
import sbwebtry.tliastry.service.Empservice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class Empserviceimp implements Empservice {

    @Autowired
    private Empmapper empmapper;

    @Override
    public PageBean getall(Integer page, Integer pagesize, String name,Short gender, LocalDate begin, LocalDate end) {
        PageHelper.startPage(page,pagesize);

        List<Emp> empListe = empmapper.getlist(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empListe;

        PageBean now = new PageBean(p.getTotal(),p.getResult());
        return now;
    }

    @Override
    public void delete(List<Integer> ids) {
        empmapper.delete(ids);
    }

    @Override
    public void add(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empmapper.add(emp);
    }

    @Override
    public Emp getbyid(Integer id) {
        return empmapper.getbyid(id);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empmapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empmapper.login(emp);
    }

/*    @Override
    public PageBean getall(Integer page,Integer pagesize) {
        long count = empmapper.getcount();
        Integer start = (page - 1) * pagesize;
        Integer fin = pagesize;
        List<Emp> now = empmapper.getall(start,fin);
        return new PageBean(count,now);
    }*/
}
