/*******************************************************************************
 * Copyright (c) 2018 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.microprofile.config.fat.suite;

import componenttest.rules.repeater.EE8FeatureReplacementAction;
import componenttest.rules.repeater.FeatureReplacementAction;

/**
 *
 */
public class RepeatConfig11EE8 extends EE8FeatureReplacementAction {

    public static final FeatureReplacementAction INSTANCE = new RepeatConfig11EE8();

    public RepeatConfig11EE8() {
        super();
        removeFeature("mpConfig-1.2");
        addFeature("mpConfig-1.1");
    }

}
