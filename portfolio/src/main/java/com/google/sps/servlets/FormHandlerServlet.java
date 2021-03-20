package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String firstValue = request.getParameter("first-input");
    String lastValue = request.getParameter("last-input");
    String emailValue = request.getParameter("email-input");
    String phoneValue = request.getParameter("phone-input");

    // Print the value so you can see it in the server logs.
    System.out.println(
        "Name: " + firstValue + " " + lastValue + ", Email Address: " + emailValue + ", Phone Number: " + phoneValue);

    // Write the value to the response so the user can see it.
    response.getWriter().println(
        "Name: " + firstValue + " " + lastValue + ", Email Address: " + emailValue + ", Phone Number: " + phoneValue);

    response.sendRedirect("/contact.html");
  }
}