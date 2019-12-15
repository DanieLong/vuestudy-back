package com.lk.test.vuestudy.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author longke
 * @date 2019/12/12 21:15
 */

@Service
public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        Object obj = authentication.getDetails();
        logger.info("User: " + request.getParameter("username") + " Login successfully.");
        this.returnJson(response);
    }


    private void returnJson(HttpServletResponse response) throws IOException {

        response.setStatus(HttpServletResponse.SC_OK);

        response.setCharacterEncoding("UTF-8");

        response.setContentType("application/json");

        response.getWriter().println("{\"exceptionId\":\"null\",\"messageCode\":\"200\"," +
                "\"message\": \"Login successfully.\",\"serverTime\": " + System.currentTimeMillis() + "}");

    }
}
