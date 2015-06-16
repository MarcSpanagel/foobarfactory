package de.spanagel.cdi;

import de.spanagel.impl.BarBean;
import de.spanagel.impl.FooBarBean;
import de.spanagel.impl.FooBean;


public enum Action {
	Foo(FooBean.class), Bar(BarBean.class);

      private Class<? extends FooBarBean> clazz;

      private Action(Class<? extends FooBarBean> clazz)
      {
         this.clazz = clazz;
      }

      public Class<? extends FooBarBean> getClazz()
      {
         return clazz;
      }
}
