package logger.weight.controller;


import logger.weight.model.ChartPair;
import logger.weight.model.Weight;
import logger.weight.service.WeightService;

import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {
        WeightServlet.LIST_ACTION,
        WeightServlet.ADD_ACTION,
        WeightServlet.DETAILS_ACTION,
        WeightServlet.REMOVE_ACTION
})

public class WeightServlet extends HttpServlet{

    public static final String TEXT_HTML = "text/html";
    public static final String LIST_ACTION = "/";
    public static final String WEIGHT_LIST = "weightList";
    public static final String ADD_ACTION = "/add";
    public static final String DETAILS_ACTION= "/details";
    public static final String WEIGHT_ID = "weightId";
    public static final String REMOVE_ACTION = "/remove";

    private WeightService weightService;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType(TEXT_HTML);

        if(request.getServletPath().equals(DETAILS_ACTION)){
            weightDetails(request, response);
        }   else if(request.getServletPath().equals(ADD_ACTION)) {
            weightForm(response, request);
        }   else if(request.getServletPath().equals(REMOVE_ACTION)) {
            weightRemoveConfirm(request, response);
        } else {
            weightList(request, response);
        }
    }

    private void weightRemoveConfirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paramId = request.getParameter(WEIGHT_ID);   //napis paramId jest równy parametrowi WEIGHT_ID pobranemu jako request
        request.setAttribute("weightId", paramId);
        request.getRequestDispatcher("remove.jsp").forward(request, response);
    }

    private void weightForm(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException{
        request.getRequestDispatcher("form.jsp").forward(request, response);
    }

    private void weightList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       List<Weight> allWeight = weightService.findAll();
        request.setAttribute(WEIGHT_LIST, weightService.findAll());
        prepareDataForChart(request,allWeight);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }
    private void weightDetails(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String paramId = request.getParameter(WEIGHT_ID);
        if (paramId == null || paramId.equals("")) {
            response.sendRedirect("/weight-servlet");
        } else {
            request.setAttribute("weightDetails",weightService.findOne(Integer.valueOf(paramId)));
            request.getRequestDispatcher("details.jsp").forward(request, response);
        }
    }

    private void prepareDataForChart(HttpServletRequest request, List<Weight> allWeight) {
        request.setAttribute("chartData", new Gson().toJson(
                allWeight.stream()
                        .map(a -> new ChartPair(a.getDate(),a.getWeight()))
                        .collect(Collectors.toList())
                )
        );
        request.setAttribute("chartTitle", "chartData");
    }




    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //delete request
        if (request.getServletPath().equals(REMOVE_ACTION)) {
            String weightToRemoveId = request.getParameter("weightToRemoveId");
            weightService.remove(Integer.valueOf(weightToRemoveId));
            response.sendRedirect("weight-servlet");

        } else {
            //otherwise send reqest from form

            String name = request.getParameter("weightName");
            String weight = request.getParameter("weight");
            String description = request.getParameter("weightDescription");
            String date = request.getParameter("date");

            String timeStamp = new SimpleDateFormat("dd-MM-YYYY").format(Calendar.getInstance().getTime());
            if (date == "")
                date = timeStamp;

            weightService.add(new Weight(WeightService.CURRENT_INDEX++, name, Double.valueOf(weight), description, date));
            response.sendRedirect("/weight-servlet");
        }
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




