package com.lnminh;


import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");
        if (action == null || action.equals("welcome")) {
            return mapping.findForward("welcome");
        } else if (action.equals("farewell")) {
            return mapping.findForward("farewell");
        }
        return mapping.findForward("hello");
    }
}
