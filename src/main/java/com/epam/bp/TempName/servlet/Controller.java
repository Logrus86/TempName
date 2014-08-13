package com.epam.bp.TempName.servlet;

import com.epam.bp.TempName.action.Action;
import com.epam.bp.TempName.action.ActionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends javax.servlet.http.HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionName = request.getParameter("action");
        LOGGER.info("doPost: actionName: " + actionName);
        Action action = ActionFactory.getAction(actionName);
        String result = action.execute(request);
        request.getRequestDispatcher(result).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionName = request.getParameter("action");
        LOGGER.info("doGet: actionName: " + actionName);
        Action action = ActionFactory.getAction(actionName);
        String result = action.execute(request);
        request.getRequestDispatcher(result).forward(request, response);
    }
}
