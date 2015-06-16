package de.spanagel.cdi;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import de.spanagel.impl.BarBean;
import de.spanagel.impl.FooBarBean;
import de.spanagel.impl.FooBean;

@Retention(RUNTIME)
@Target({FIELD, TYPE, METHOD})
public @interface FooBarType {
	Action value();
}
