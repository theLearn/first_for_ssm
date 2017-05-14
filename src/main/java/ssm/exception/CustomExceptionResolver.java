package ssm.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 错误信息统一处理
 * 对未处理的错误信息做一个统一处理
 * Created by hongcheng on 17/4/27.
 *
 */
@Component
public class CustomExceptionResolver implements HandlerExceptionResolver {

    private Logger log = LoggerFactory.getLogger(CustomExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        log.error("access" + httpServletRequest.getRequestURI() + " create error errMsg = " + e.getMessage());

        ActionException ae = ExceptionHandler.handleException(e);
        String errMsg = ae.getErrorMessage();

        ModelAndView view = new ModelAndView();
        view.addObject("errMsg", errMsg);
        view.setViewName("error");
        return view;
    }
}
