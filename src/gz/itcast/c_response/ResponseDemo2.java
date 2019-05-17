package gz.itcast.c_response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 案例- 请求重定向
 * （相当于超链接跳转页面）
 *
 */
public class ResponseDemo2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    /**
     * 需求： 跳转到adv.html
     * 使用请求重定向： 发送一个302状态码+location的响应头
     */
//      response.setStatus(302);
//      response.setHeader("location","/adv.html");

        //请求重定向简化写法
        response.sendRedirect("/adv.html");
    }
}
