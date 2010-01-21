/*
 * JBoss, Home of Professional Open Source
 * Copyright 2008, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.jsr299.tck.tests.deployment.lifecycle.broken.useBeforeValidationFails;

import org.jboss.jsr299.tck.AbstractJSR299Test;
import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecAssertions;
import org.jboss.test.audit.annotations.SpecVersion;
import org.jboss.testharness.impl.packaging.Artifact;
import org.testng.annotations.Test;

/**
 * Tests that the container will not allow requests to be processed until after
 * all observers of the AfterDeploymentValidation event have completed.
 * 
 * @author David Allen
 *
 */
@Artifact
@SpecVersion(spec="cdi", version="20091101")
public class UseBeforeValidationTest extends AbstractJSR299Test
{
   @Test(groups = {"broken", "rewrite"})
   //Still not clear how the container should now allow this, but the RI is clearly not implementing this assertion
   // TODO Needs Extension stuff adding
   // TODO very hard to test
   // WBRI-300
   @SpecAssertions({
      @SpecAssertion(section = "11.5.3", id = "d"),
      @SpecAssertion(section = "12.2", id = "h")
   })
   public void testRequestBeforeValidationCompletes()
   {
      assert ManagerObserver.isManagerDeployed();
      assert !StringObserver.eventReceived;
   }

}