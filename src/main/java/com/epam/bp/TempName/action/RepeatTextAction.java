package com.epam.bp.TempName.action;

import javax.servlet.http.HttpServletRequest;

public class RepeatTextAction implements Action {
    @Override
    public String execute(HttpServletRequest request) {
        String text = request.getParameter("text");
        request.setAttribute("text", text);
        return "/WEB-INF/jsp/repeatText.jsp";
    }
}
