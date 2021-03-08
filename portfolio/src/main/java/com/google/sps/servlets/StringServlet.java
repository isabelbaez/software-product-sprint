package com.google.sps.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/string")
public final class StringServlet extends HttpServlet {

    /**  ONE HARD CODED STRING
     * @Override 
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;");
    response.getWriter().println("I did it!");
  }
} */

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    String[] sentences = {"This is hard.", "This is fun.", "This is intersting."};

    // Convert the server stats to JSON
    String json = convertToJson(sentences);

    // Send the JSON as the response
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }

  private String convertToJson(String[] sentences) {
    String json = "{";
    json += "\"string1\": ";
    json += "\"" + sentences[0] + "\"";
    json += ", ";
    json += "\"string2\": ";
    json += "\"" + sentences[1] + "\"";
    json += ", ";
    json += "\"string3\": ";
    json += "\"" + sentences[2] + "\"";
    json += "}";
    return json;
  }

  private String convertToJsonUsingGson(String[] sentences) {
    Gson gson = new Gson();
    String json = gson.toJson(sentences);
    return json;
  }
}

