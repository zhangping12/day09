package gz.itcast.c_response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 设置响应信息
 *
 */
public class ResponseDemo1 extends HttpServlet {
    /**
     * 1)tomcat服务器把请求信息封装到HttpServletRequest对象，且把响应信息封装到HttpServletResponse
     * 2）tomcat服务器调用doGet方法，传入request和response对象
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 3）通过response对象改变响应信息
         */
        //3.1响应行
//        resp.setStatus(404);//修改状态码
//        resp.sendError(404);// 发送404的状态码+404的错误页面

        //3.2响应头
        resp.setHeader("server","Jboss");

        //3.3 实体内容(浏览器直接能够看到的内容就是实体内容)
        resp.getWriter().write("01.hello world");//字符内容
        resp.getOutputStream().write("02.hello world".getBytes());//字节内容
    }
    /**
     * 4)tomcat服务器把response对象的内容转换成响应格式内容，再发送给浏览器解析。
     */
}
