/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jboss.forge.addon.facets;

/**
 * A {@link Facet} is an access point to common functionality, file manipulations, descriptors that extend a
 * {@link Faceted} instance. When implementing this interface, consider extending {@link BaseFacet} for convenience.
 * 
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * @author <a href="http://community.jboss.org/people/kenfinni">Ken Finnigan</a>
 * 
 * @see {@link BaseFacet}
 */
public interface Facet<FACETED extends Faceted>
{
   /**
    * Return the {@link Faceted} instance on which this {@link Facet} operates.
    */
   FACETED getOrigin();

   /**
    * Perform necessary setup for this {@link Facet} to be considered installed in the given {@link Faceted} instance.
    * This method should NOT register the facet; facet registration is handled by the {@link Faceted} instance if
    * installation is successful.
    * 
    * @return true if installation was successful, false if not.
    */
   boolean install();

   /**
    * Return true if the {@link Facet} is available for the given {@link Faceted} instance, false if otherwise.
    */
   boolean isInstalled();

   /**
    * Remove this {@link Facet} from its {@link Faceted} instance, and perform any necessary cleanup.
    */
   boolean uninstall();
}
