/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.jboss.forge.ui.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

import org.jboss.forge.environment.Environment;
import org.jboss.forge.ui.UIInput;
import org.jboss.forge.ui.UIInputMany;
import org.jboss.forge.ui.UISelectMany;
import org.jboss.forge.ui.UISelectOne;
import org.jboss.forge.ui.impl.facets.HintsFacetImpl;

/**
 * Produces UIInput objects
 * 
 * @author <a href="mailto:ggastald@redhat.com">George Gastaldi</a>
 * 
 */
public class UIInputProducer
{
   @Inject
   private Environment environment;

   @Produces
   @SuppressWarnings("unchecked")
   public <T> UISelectOne<T> produceSelectOne(InjectionPoint injectionPoint)
   {
      String name = injectionPoint.getMember().getName();
      Type type = injectionPoint.getAnnotated().getBaseType();

      if (type instanceof ParameterizedType)
      {
         ParameterizedType parameterizedType = (ParameterizedType) type;

         Type[] typeArguments = parameterizedType.getActualTypeArguments();
         Class<T> valueType = (Class<T>) typeArguments[0];
         UISelectOne<T> result = new UISelectOneImpl<T>(name, valueType);
         HintsFacetImpl hintsFacet = new HintsFacetImpl(result, environment);
         result.install(hintsFacet);
         return result;
      }
      else
      {
         throw new IllegalStateException("Cannot inject a generic instance of type " + UIInput.class.getName()
                  + "<?,?> without specifying concrete generic types at injection point " + injectionPoint + ".");
      }
   }

   @Produces
   @SuppressWarnings({ "unchecked" })
   public <T> UISelectMany<T> produceSelectMany(InjectionPoint injectionPoint)
   {
      String name = injectionPoint.getMember().getName();
      Type type = injectionPoint.getAnnotated().getBaseType();

      if (type instanceof ParameterizedType)
      {
         ParameterizedType parameterizedType = (ParameterizedType) type;

         Type[] typeArguments = parameterizedType.getActualTypeArguments();
         Class<T> valueType = (Class<T>) typeArguments[0];
         UISelectMany<T> result = new UISelectManyImpl<T>(name, valueType);
         HintsFacetImpl hintsFacet = new HintsFacetImpl(result, environment);
         result.install(hintsFacet);
         return result;
      }
      else
      {
         throw new IllegalStateException("Cannot inject a generic instance of type " + UIInput.class.getName()
                  + "<?,?> without specifying concrete generic types at injection point " + injectionPoint + ".");
      }
   }

   @Produces
   @SuppressWarnings({ "unchecked" })
   public <T> UIInput<T> produceInput(InjectionPoint injectionPoint)
   {
      String name = injectionPoint.getMember().getName();
      Type type = injectionPoint.getAnnotated().getBaseType();

      if (type instanceof ParameterizedType)
      {
         ParameterizedType parameterizedType = (ParameterizedType) type;

         Type[] typeArguments = parameterizedType.getActualTypeArguments();
         Class<T> valueType = (Class<T>) typeArguments[0];
         UIInputImpl<T> result = new UIInputImpl<T>(name, valueType);
         HintsFacetImpl hintsFacet = new HintsFacetImpl(result, environment);
         result.install(hintsFacet);
         return result;
      }
      else
      {
         throw new IllegalStateException("Cannot inject a generic instance of type " + UIInput.class.getName()
                  + "<?,?> without specifying concrete generic types at injection point " + injectionPoint + ".");
      }
   }

   @Produces
   @SuppressWarnings({ "unchecked" })
   public <T> UIInputMany<T> produceInputMany(InjectionPoint injectionPoint)
   {
      String name = injectionPoint.getMember().getName();
      Type type = injectionPoint.getAnnotated().getBaseType();

      if (type instanceof ParameterizedType)
      {
         ParameterizedType parameterizedType = (ParameterizedType) type;

         Type[] typeArguments = parameterizedType.getActualTypeArguments();
         Class<T> valueType = (Class<T>) typeArguments[0];
         UIInputManyImpl<T> result = new UIInputManyImpl<T>(name, valueType);
         HintsFacetImpl hintsFacet = new HintsFacetImpl(result, environment);
         result.install(hintsFacet);
         return result;
      }
      else
      {
         throw new IllegalStateException("Cannot inject a generic instance of type " + UIInput.class.getName()
                  + "<?,?> without specifying concrete generic types at injection point " + injectionPoint + ".");
      }
   }
}
