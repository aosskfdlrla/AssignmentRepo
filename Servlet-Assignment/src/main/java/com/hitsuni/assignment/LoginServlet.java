package com.hitsuni.assignment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");

        if(id.equals("admin") && pw.equals("12345")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<html>")
                    .append("<head>")
                    .append("<title>로그인</title>")
                    .append("</head>")
                    .append("<body>")
                    .append("<h1>안녕하세요 ")
                    .append(id)
                    .append("님, 누추한 웹페이지에 오신 것을 환영합니다.")
                    .append("</h1>")
                    .append("</body>")
                    .append("</head>");

            resp.setContentType("text/html");

            // 사용자 브라우저에 응답하기 위한 출력 스트림을 response 객체에서 반환 받는다.
            PrintWriter writer = resp.getWriter();
            writer.print(stringBuilder);
            writer.flush(); // 버퍼에 잔류한 데이터 내보내기
            writer.close(); // 스트림 반환
        } else {
            resp.sendError(405, "아이디와 비밀번호를 잘못 입력하셨습니다~? 다시 시도하세요~!");
        }
    }
}
