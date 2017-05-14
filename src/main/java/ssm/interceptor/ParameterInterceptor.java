package ssm.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by hongcheng on 17/5/13.
 */
public class ParameterInterceptor  implements HandlerInterceptor {

    private Logger log = Logger.getLogger(ParameterInterceptor.class.getName());

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        log.info("preHandle : " + httpServletRequest.getRequestURI());
        log.info("preHandle : " + httpServletRequest.getMethod());

        if(RequestMethod.GET.name().equals(httpServletRequest.getMethod()))
        {
            Map map = new HashMap();
            Enumeration paramNames = httpServletRequest.getParameterNames();
            while (paramNames.hasMoreElements()) {
                String paramName = (String) paramNames.nextElement();

                String[] paramValues = httpServletRequest.getParameterValues(paramName);
                if (paramValues.length == 1) {
                    String paramValue = paramValues[0];
                    if (paramValue.length() != 0) {
                        map.put(paramName, paramValue);
                    }
                }
            }

            Set<Map.Entry<String, String>> set = map.entrySet();
            for (Map.Entry entry : set) {
                log.info(entry.getKey() + ":" + entry.getValue());
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        log.info("postHandle : " + httpServletRequest.getRequestURI());
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        log.info("afterCompletion : " + httpServletRequest.getRequestURI());
    }
}
