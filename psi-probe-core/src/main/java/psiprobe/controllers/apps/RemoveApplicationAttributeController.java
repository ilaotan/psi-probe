/*
 * Licensed under the GPL License. You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   https://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 *
 * THIS PACKAGE IS PROVIDED "AS IS" AND WITHOUT ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING,
 * WITHOUT LIMITATION, THE IMPLIED WARRANTIES OF MERCHANTIBILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE.
 */
package psiprobe.controllers.apps;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Context;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import psiprobe.controllers.AbstractContextHandlerController;

/**
 * The Class RemoveApplicationAttributeController.
 */
@Controller
public class RemoveApplicationAttributeController extends AbstractContextHandlerController {

  @RequestMapping(path = "/app/rmappattr.htm")
  @Override
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    return super.handleRequest(request, response);
  }

  @Override
  protected ModelAndView handleContext(String contextName, Context context,
      HttpServletRequest request, HttpServletResponse response) throws Exception {

    String attrName = ServletRequestUtils.getStringParameter(request, "attr");
    context.getServletContext().removeAttribute(attrName);

    return new ModelAndView(new RedirectView(
        request.getContextPath() + getViewName() + "?" + request.getQueryString()));
  }

  @Value("appattributes")
  @Override
  public void setViewName(String viewName) {
    super.setViewName(viewName);
  }

}
