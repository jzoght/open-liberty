/*******************************************************************************
 * Copyright (c) 2016 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.microprofile.config.fat.tests;

import org.jboss.shrinkwrap.api.Archive;
import org.junit.ClassRule;
import org.junit.Test;

import com.ibm.ws.fat.util.BuildShrinkWrap;
import com.ibm.ws.fat.util.LoggingTest;
import com.ibm.ws.fat.util.SharedServer;
import com.ibm.ws.fat.util.ShrinkWrapSharedServer;
import com.ibm.ws.fat.util.browser.WebBrowser;
import com.ibm.ws.microprofile.config.fat.suite.SharedShrinkWrapApps;

/**
 *
 */
public class CDIMethodInjectionTest extends LoggingTest {

    @ClassRule
    public static SharedServer SHARED_SERVER = new ShrinkWrapSharedServer("CDIConfigServer");

    @BuildShrinkWrap
    public static Archive buildApp() {
        return SharedShrinkWrapApps.cdiConfigServerApps();
    }

    @Override
    protected SharedServer getSharedServer() {
        return SHARED_SERVER;
    }

    @Test
    public void testMethod() throws Exception {
        test("SIMPLE_KEY6", "VALUE6");
    }

    private void test(String key, String expected) throws Exception {
        WebBrowser browser = createWebBrowserForTestCase();
        getSharedServer().verifyResponse(browser, "/cdiConfig/xtor?key=" + key, key + "=" + expected);
    }
}
