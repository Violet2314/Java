package sbwebtry.tliastry.service;

import sbwebtry.tliastry.pojo.Dept;

import java.util.List;

public interface Deptservice {
    public List<Dept> getall();

    public void delete(Integer id) throws Exception;

    void add(Dept dept);

    void update(Dept dept);

    Dept getbyid(Integer id);
}
