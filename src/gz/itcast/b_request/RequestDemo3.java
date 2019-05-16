package gz.itcast.b_request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 案例-获取浏览器的类型
 */
public class RequestDemo3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");//设置web页面显示编码:jsp的输出流在浏览器中显示的编码
        //获取请求头：user-agent
        String userAgent = req.getHeader("user-agent");
        System.out.println(userAgent);

        //判断用户使用的浏览器类型
        if (userAgent.contains("Firefox")){
            resp.getWriter().write("你正在使用火狐浏览器");
        }else if(userAgent.contains("Chrome")){
            resp.getWriter().write("你正在使用谷歌浏览器");
        }else if(userAgent.contains("Trident")){
            resp.getWriter().write("你正在使用IE浏览器");
        }else{
            resp.getWriter().write("地球上没有这个浏览器，建议使用火狐浏览器");
        }
    }
}
