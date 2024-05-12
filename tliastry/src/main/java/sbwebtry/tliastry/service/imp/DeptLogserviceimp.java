package sbwebtry.tliastry.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sbwebtry.tliastry.mapper.DeptLogmapper;
import sbwebtry.tliastry.pojo.DeptLog;
import sbwebtry.tliastry.service.DeptLogservice;

@Service
public class DeptLogserviceimp implements DeptLogservice {

    @Autowired
    private DeptLogmapper deptLogmapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insert(DeptLog deptLog) {
        deptLogmapper.insert(deptLog);
    }
}
