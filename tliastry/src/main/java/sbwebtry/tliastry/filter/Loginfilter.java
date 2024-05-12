package sbwebtry.tliastry.filter;

import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import sbwebtry.tliastry.pojo.Result;
import sbwebtry.tliastry.utils.JwtUtils;

import java.io.IOException;

@Slf4j
@Component
@WebFilter(urlPatterns = "/*")
public class Loginfilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String url = req.getRequestURL().toString();
        log.info("我请求的url{}",url);

        if(url.contains("login")){
            log.info("登录操作，放行");
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        String jwt = req.getHeader("token");

        //不为null也不为空字符串
        if(!StringUtils.hasLength(jwt)){
            log.info("为空串");
            Result error = Result.error("NOT_LOGIN");
            String falselongin = JSONObject.toJSONString(error);
            resp.getWriter().write(falselongin);
            return;
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
            return;
        }

        log.info("合法，放行");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
