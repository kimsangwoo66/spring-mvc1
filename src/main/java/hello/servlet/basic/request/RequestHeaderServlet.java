package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        printStartLine(request);
        printHeaders(request);
        printHeaderUtils(request);
        printEtc(request);
//        response.getWriter().write("ok");
    }

    private void printStartLine(HttpServletRequest request) {
        System.out.println("--- REQUEST-LINE - start ---");
        System.out.println("request.getMethod() = " + request.getMethod()); //GET
        System.out.println("request.getProtocal() = " + request.getProtocol()); // HTTP/1.1
        System.out.println("request.getScheme() = " + request.getScheme());

        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        System.out.println("request.getRequestURI() = " + request.getRequestURI()); //username=hi
        System.out.println("request.getQueryString() = " +request.getQueryString());
        System.out.println("request.isSecure() = " + request.isSecure()); //https
        //사용 유무
        System.out.println("--- REQUEST-LINE - end ---");
        System.out.println();
    }

    private void printHeaders(HttpServletRequest request) {
        System.out.println("--- Headers - start ---");

        //http에 있는 모든 헤더정보를 다 꺼내서 출력가능
//        Enumeration<String> headernames = request.getHeaderNames();
//        while (headernames.hasMoreElements()){
//            String headerName = headernames.nextElement();
//            System.out.println(headerName + ":" + headerName);
//        }
        request.getHeaderNames().asIterator().
                forEachRemaining(headerName -> System.out.println("headerName =" +headerName));



        System.out.println("--- Headers - end ---");
        System.out.println();
    }
    private void printHeaderUtils(HttpServletRequest request) {
        System.out.println("--- Header 편의 조회 start ---"); System.out.println("[Host 편의 조회]");
        System.out.println("request.getServerName() = " + request.getServerName()); //Host 헤더
        System.out.println("request.getServerPort() = " + request.getServerPort()); //Host 헤더
        System.out.println();

        System.out.println("[Accept-Language 편의 조회]");
        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " + locale));
        //locales 는 지역/언어 정보, getLocales는 가장 위에있는 로컬케일 정보를 가져온다.
        System.out.println("request.getLocale() = " + request.getLocales());
        System.out.println();

        System.out.println("[cookie 편의 조회]");
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) { System.out.println(cookie.getName() + ": " + cookie.getValue());
            } }
        System.out.println();
        System.out.println("[Content 편의 조회]");
        System.out.println("request.getContentType() = " + request.getContentType());
        System.out.println("request.getContentLength() = " +
                request.getContentLength()); System.out.println("request.getCharacterEncoding() = " +
                request.getCharacterEncoding());
        System.out.println("--- Header 편의 조회 end ---");
        System.out.println(); }

    private void printEtc(HttpServletRequest request) { System.out.println("--- 기타 조회 start ---");
        System.out.println("[Remote 정보]"); //요청이 온것에 대한 정보,내부에서 네트워크 커넥션이 이루어진 정보
        System.out.println("request.getRemoteHost() = " + request.getRemoteHost()); //
        System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr()); //
        System.out.println("request.getRemotePort() = " + request.getRemotePort()); //
        System.out.println();
        System.out.println("[Local 정보]"); //내 서버에 대한 정보
        System.out.println("request.getLocalName() = " + request.getLocalName()); //
        System.out.println("request.getLocalAddr() = " + request.getLocalAddr()); //
        System.out.println("request.getLocalPort() = " + request.getLocalPort()); //
        System.out.println("--- 기타 조회 end ---");
        System.out.println();
    }
}
