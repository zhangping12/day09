package gz.itcast.b_request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

public class RequestDemo1 extends HttpServlet{
    /**
     * 1）tomcat服务器接收到浏览器发送的请求数据，然后封装到HttpServletRequest对象
     * 2）tomcat服务器调用doGet方法，然后把request对象传入到servlet中。
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 3）从request对象取出请求数据
         */
//       t1(req);
//       t2(req);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //3.3请求的实体内容
        InputStream in = req.getInputStream();//得到实体内容
        byte[] buf = new byte[1024];
        int len = 0;
        while((len = in.read(buf))!=-1){
            String str = new String(buf,0,len);
            System.out.println(str);
        }
    }

    private void t2(HttpServletRequest req) {
        //3.2请求头
        String host = req.getHeader("Host");//根据头名称得到头内容
        System.out.println(host);
        //遍历所有请求头
        Enumeration<String> enums = req.getHeaderNames();//得到所有的请求头名称列表
        while(enums.hasMoreElements()){
           String headerName = enums.nextElement();//取出下一个元素
           String headerValue = req.getHeader(headerName);
            System.out.println(headerName+":"+headerValue);
        }
    }

    private void t1(HttpServletRequest req) {
        //3.1请求行 格式：（GET /day09/hello HTTP/1.1）
        System.out.println("请求方式："+req.getMethod());//请求方式
        System.out.println("URI："+req.getRequestURI());//请求资源
        System.out.println("URL："+req.getRequestURL());
        System.out.println("http协议版本："+req.getProtocol());//http协议
    }
}
