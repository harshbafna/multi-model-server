/*
 * Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance
 * with the License. A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0/
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package org.torch.serve.servingsdk.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.torch.serve.util.ConfigManager;
import org.torch.serve.wlm.ModelManager;

import software.amazon.ai.mms.servingsdk.Context;
import software.amazon.ai.mms.servingsdk.Model;

public class ModelServerContext implements Context {
    @Override
    public Properties getConfig() {
        return ConfigManager.getInstance().getConfiguration();
    }

    @Override
    public Map<String, Model> getModels() {
        HashMap<String, Model> r = new HashMap<>();
        ModelManager.getInstance().getModels().forEach((k, v) -> r.put(k, new ModelServerModel(v)));
        return r;
    }
}
