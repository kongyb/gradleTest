package org.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Test3Servlet", value = "/test3")
public class Test3Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg", "바뀐 메세지입니다.");
        List<String> list = new ArrayList<>();
        list.add("message1");
        list.add("message2");
        list.add("message3");
        list.add("message4");
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/test.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}