package logger.weight.controller;


import logger.weight.model.Weight;
import logger.weight.service.WeightService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {
        WeightServlet.LIST_ACTION,
        WeightServlet.ADD_ACTION,
        WeightServlet.DETAILS_ACTION
})

public class WeightServlet extends HttpServlet{

    public static final String TEXT_HTML = "text/html";
    public static final String LIST_ACTION = "/";
    public static final String WEIGHT_LIST = "weightList";
    public static final String ADD_ACTION ="/add";
    public static final String DETAILS_ACTION="/details";
    public static final String WEIGHT_ID = "weightId";

    private WeightService weightService;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType(TEXT_HTML);

        if(request.getServletPath().equals(DETAILS_ACTION)){
            weightDetails(request,response);
        }   else if(request.getServletPath().equals(ADD_ACTION)) {
            weightForm(response, request);
        }
        else {
            weightList(request, response);
        }
    }

    private void weightForm(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException{
        request.getRequestDispatcher("form.jsp").forward(request, response);
    }

    private void weightList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute(WEIGHT_LIST, weightService.findAll());
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }
    private void weightDetails(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String paramId = request.getParameter(WEIGHT_ID);
        if (paramId == null || paramId.equals("")) {
            response.sendRedirect("/weight-servlet");
        } else {
            request.setAttribute("weightDetails",weightService.findOne(Integer.valueOf(paramId)));
            request.getRequestDispatcher("details.jsp").forward(request,response);
        }
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String name = request.getParameter("weightName");
        String weight = request.getParameter("weight");
        String description = request.getParameter("weightDescription");

        weightService.add(new Weight(WeightService.CURRENT_INDEX++,name,Double.valueOf(weight),description));;
        response.sendRedirect("/weight-servlet");
    }




    @Override
    public void init() throws ServletException {
        System.out.println("Servlet " + this.getServletName() + " has started");
        weightService = new WeightService();
    }
    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped");
    }

}




