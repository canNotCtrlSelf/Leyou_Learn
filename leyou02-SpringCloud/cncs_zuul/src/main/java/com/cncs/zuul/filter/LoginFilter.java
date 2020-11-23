package com.cncs.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录过滤器
 */
@Component //将过滤器放入spring容器中
public class LoginFilter extends ZuulFilter {
    //过滤器类型：pre，route，post，error
    @Override
    public String filterType() {
        return "pre";
    }

    //过滤器优先级，注意从10 or 20开始，留有余量，方便扩展
    @Override
    public int filterOrder() {
        return 10;
    }

    //是否启用过滤器，true：启用
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 编写过滤器中的业务逻辑：判断请求参数中是否有token参数，有的话就放行，否则返回null
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //获取context
        RequestContext context = RequestContext.getCurrentContext();
        //获取request
        HttpServletRequest request = context.getRequest();
        //获取taken参数
        String token = request.getParameter("token");
        if(StringUtils.isBlank(token)){
            //如果token为空，则拦截该请求，不对其进行路由
            context.setSendZuulResponse(false);
            //设置响应状态码，401，未认证
            context.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            //设置响应提示信息
            context.setResponseBody("401,Request Error!");
        }
        //认证成功，将登录信息放入上下文信息，然后继续执行
        context.set("token",token);
        return null;
    }
}
