package sbwebtry.tliastry.controller;

import com.aliyun.oss.allyunossspringbootautoconfigure.AliOSSUtils;
import com.aliyuncs.exceptions.ClientException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sbwebtry.tliastry.pojo.Result;



import java.io.IOException;



@Slf4j
@RestController
public class UploadController {

/*    @PostMapping("/upload")
    public Result upload(String name, Integer age, MultipartFile image) throws IOException {
        log.info("之前的文件名{},{},{}",name,age,image);
        String originalFilename = image.getOriginalFilename();

        int index = originalFilename.lastIndexOf(".");
        String substringed= originalFilename.substring(index);
        String newfile = UUID.randomUUID().toString() + substringed;s

        log.info("新的文件名{}",newfile);

        image.transferTo(new File("D:\\compiler\\" + newfile));//忘记加后面的\\了

        return Result.success();
    }*/


    @Autowired
    private AliOSSUtils aliOSSUtils;
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException, ClientException {
        String url = aliOSSUtils.upload(image);
        return Result.success(url);
    }
}
