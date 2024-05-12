package sbwebtry.mybati;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sbwebtry.mybati.mapper.mapper.UserMapper;
import sbwebtry.mybati.pojo.User;

import java.util.List;

@SpringBootTest
class MybatiApplicationTests {

    @Autowired
    private UserMapper userr;

    @Test
    public void tese(){
        List<User> sList = userr.list(1);
        sList.stream().forEach(user -> {
            System.out.println(user);
        });
    }


}
