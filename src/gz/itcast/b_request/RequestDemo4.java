package gz.itcast.b_request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 案例- 防止非法链接
 * 这是需要下载的资源
 *
 */
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //得到referer头
        String referer = req.getHeader("referer");
        System.out.println("referer="+referer);
        /**
         * 判断非法链接：
         * 	1）直接访问的话referer=null
         *  2）如果当前请求不是来自广告
         */
        if(referer==null||!referer.contains("/adv.html")){
            resp.getWriter().write("当前是非法链接，请回到首页。<a href='/adv.html'>首页</a>");
        }else{
           //正确的链接
            resp.getWriter().write("资源正在下载...");
        }
    }
}
