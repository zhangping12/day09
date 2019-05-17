package gz.itcast.c_response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 案例- 定时刷新
 *
 */
public class ResponseDemo3 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 定时刷新
         * 原理：浏览器认识refresh头，得到refresh头之后重新请求当前资源
         */
//        response.setHeader("refresh","1");//每隔1秒刷新此页面

        /**
         * 隔n秒之后跳转另外的资源
         */
        response.setHeader("refresh","3;url=/adv.html");//隔3秒之后跳转到adv.html

    }
}
