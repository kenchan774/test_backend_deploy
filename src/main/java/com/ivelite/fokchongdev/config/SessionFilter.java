package com.ivelite.fokchongdev.config;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class SessionFilter implements Filter {
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;
    Cookie[] allCookies = req.getCookies();
    if (allCookies != null) {
      Cookie session =
          Arrays.stream(allCookies)
              .filter(x -> x.getName().equals("JSESSIONID"))
              .findFirst()
              .orElse(null);

      if (session != null) {
        session.setHttpOnly(false);
        session.setSecure(false);
        res.addCookie(session);
      }
    }
    chain.doFilter(req, res);
  }
}
