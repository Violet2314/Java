package sbwebtry.tliastry.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sbwebtry.tliastry.mapper.DeptLogmapper;
import sbwebtry.tliastry.mapper.Deptmapper;
import sbwebtry.tliastry.mapper.Empmapper;
import sbwebtry.tliastry.pojo.Dept;
import sbwebtry.tliastry.pojo.DeptLog;
import sbwebtry.tliastry.service.DeptLogservice;
import sbwebtry.tliastry.service.Deptservice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class Deptserviceimp implements Deptservice {

    @Autowired
    private Deptmapper deptmapper;
    @Autowired
    private Empmapper empmapper;
    @Autowired
    private DeptLogservice deptLogservice;

    @Override
    public List<Dept> getall() {
        return deptmapper.getall();
    }

    //指示要回滚的错误类型，默认，只有出现RuntimeException才回滚异常,这个是全异常Exception.class
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) throws Exception {
        try{
            empmapper.deletebydeptid(id);
            deptmapper.delete(id);
        }finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDate.now());
            deptLog.setDescription("执行了解散部门的操作");
            deptLogservice.insert(deptLog);
        }
    }

    @Override
    public void add(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        dept.setCreateTime(LocalDateTime.now());
        deptmapper.add(dept);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptmapper.update(dept);
    }

    @Override
    public Dept getbyid(Integer id) {
        return deptmapper.getbyid(id);
    }
}
