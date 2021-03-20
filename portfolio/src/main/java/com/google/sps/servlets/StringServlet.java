package com.google.sps.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/string")
public final class StringServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    String[] sentences = {"This is hard.", "This is fun.", "This is intersting."};

    // Send the JSON as the response

    Gson gson = new Gson();
    String json = gson.toJson(sentences);

    response.setContentType("application/json;");
    response.getWriter().println(json);
  }

}

