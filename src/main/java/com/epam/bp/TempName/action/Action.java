package com.epam.bp.TempName.action;

import javax.servlet.http.HttpServletRequest;

public interface Action {
    String execute(HttpServletRequest request);
}
