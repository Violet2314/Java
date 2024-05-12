package sbwebtry.tliastry.interceptor;

import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import sbwebtry.tliastry.pojo.Result;
import sbwebtry.tliastry.utils.JwtUtils;

@Slf4j
@Component
public class Logincheck implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {

        String url = req.getRequestURL().toString();
        log.info("请求的url{}",url);

        if(url.contains("login")){
            log.info("登录操作，放行");
            return true;
        }

        String jwt = req.getHeader("token");

        //不为null也不为空字符串
        if(!StringUtils.hasLength(jwt)){
            log.info("为空串");
            Result error = Result.error("NOT_LOGIN");
            String falselongin = JSONObject.toJSONString(error);
            resp.getWriter().write(falselongin);
            return false;
        }

        //5.解析token，如果解析失败，返回错误结果（未登录）。
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e){
            e.printStackTrace();
            log.info("解析失败");
            Result error = Result.error("NOT_LOGIN");
            String falselongin = JSONObject.toJSONString(error);
            resp.getWriter().write(falselongin);
            return false;
        }

        log.info("合法，放行");
        return true;
    }

    @Override//目标资源方法运行后运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle ...");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override//视图渲染完毕后运行, 最后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}

