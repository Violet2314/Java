package sbwebtry.tliastry.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sbwebtry.tliastry.pojo.Result;

import java.util.ArrayList;

/**
 * 全局异常处理器
 */

/*@RestControllerAdvice注解的类可以捕获所有Controller层抛出的异常，
包括未被处理的异常。在这个例子中，
GlobalExceptionHandler类使用@ExceptionHandler(Exception.class)注解的方法捕获所有类型的异常，
因为Exception是Java中所有异常的基类，所以它可以捕获所有异常。*/
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)//捕获所有异常
    public Result ex(Exception ex){
        ex.printStackTrace();
        return Result.error("对不起,操作失败,请联系管理员");
    }

}
