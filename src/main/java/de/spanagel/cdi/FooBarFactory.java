package de.spanagel.cdi;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Annotated;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

import de.spanagel.impl.FooBarBean;

public class FooBarFactory
{

   @Inject
   @FooBarProducer
   @FooBarType(Action.Foo)
   private FooBarBean fooBean;

   @Inject
   @FooBarProducer
   @FooBarType(Action.Bar)
   private FooBarBean barBean;

   private Map<Action, FooBarBean> beans = new HashMap<>();

   @Produces
   @FooBarProducer
   private FooBarBean createNotificationService(@Any Instance<FooBarBean> instance, InjectionPoint ip)
   {
      System.out.println("Creation of Producer");
      Annotated annotated = ip.getAnnotated();
      FooBarType fooBarType = annotated.getAnnotation(FooBarType.class);
      Action actionType = fooBarType.value();
      Class<? extends FooBarBean> beanType = actionType.getClazz();
      System.out.println(beanType.toString());
      FooBarBean bean = instance.select(beanType).get();
      System.out.println("2. Producer- selektiert- Type " + beanType.getName());
      beans.put(actionType, bean);
      System.out.println("3. Producer- in Map gesteckt " + beanType.getName());
      return bean;
   }

   public FooBarBean get(Action action)
   {
      System.out.println("1. GET-Anforderung der Bean vom Type " + action.getClazz().getName());
      FooBarBean bean = beans.get(action);
      System.out.println("4. GET-Bean geholt " + action.getClazz().getName());
      return bean;

   }
}
