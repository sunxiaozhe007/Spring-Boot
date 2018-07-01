package example.exception;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 通过实现HandlerExceptionResolver接口做全局异常处理
 */
@Configuration
public class GlobalException implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        ModelAndView mv = new ModelAndView();

        //判断不同异常类型，做不同视图跳转
        if (e instanceof ArithmeticException){
            mv.setViewName("error1");
        }
        if (e instanceof NullPointerException){
            mv.setViewName("error2");
        }
        mv.addObject("error",e.toString());

        return mv;
    }
}
