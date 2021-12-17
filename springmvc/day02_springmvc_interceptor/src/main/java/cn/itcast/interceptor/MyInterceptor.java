package cn.itcast.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class MyInterceptor implements HandlerInterceptor {

    /**
     * 预处理：controller方法执行前
     * return true:放行，执行下一个拦截器，如果没有则执行controller中的方法
     * return false:
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor1执行了");
        /**
         * 如果不放行的话，可以跳转到一个比较友好的异常处理页面
         */
        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
        return false;
    }

    /**
     * 后处理：controller方法执行后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor2执行了...后");
    }

    /**
     * success.jsp页面执行后，该方法会执行...
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor2执行了...最后");
    }
}
