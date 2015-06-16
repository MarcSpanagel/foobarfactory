package de.spanagel.servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.spanagel.cdi.Action;
import de.spanagel.cdi.FooBarFactory;
import de.spanagel.impl.FooBarBean;

@WebServlet(urlPatterns = { "/beantest" })
public class Client extends HttpServlet
{
   private static final long serialVersionUID = -3995970242890631574L;

   @Inject
   FooBarFactory factory;

   protected void doGet(HttpServletRequest request,
         HttpServletResponse response)
         throws ServletException, IOException
   {
      Action action = Action.Foo;
      if (Calendar.getInstance().get(Calendar.MINUTE) % 2 == 0)
      {
    	  action = Action.Bar;
      }
      FooBarBean bean = factory.get(action);
      bean.shout();
   }
}
