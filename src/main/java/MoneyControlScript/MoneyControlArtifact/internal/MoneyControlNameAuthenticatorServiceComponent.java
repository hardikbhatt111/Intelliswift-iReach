/*
 *  Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package MoneyControlScript.MoneyControlArtifact.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.wso2.carbon.identity.application.authentication.framework.ApplicationAuthenticator;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import MoneyControlScript.MoneyControlArtifact.MoneyControlNameAuthenticator;

import java.util.Hashtable;

@Component(name = "identity.application.authenticator.MoneyControlName.component", immediate = true)
public class MoneyControlNameAuthenticatorServiceComponent {

    private static Log log = LogFactory.getLog(MoneyControlNameAuthenticatorServiceComponent.class);

    @Activate
    protected void activate(ComponentContext ctxt) {
        try {
            MoneyControlNameAuthenticator authenticator = new MoneyControlNameAuthenticator();
            Hashtable<String, String> props = new Hashtable<>();
            ctxt.getBundleContext().registerService(ApplicationAuthenticator.class.getName(),
                    authenticator, props);
            if (log.isDebugEnabled()) {
                log.debug("MoneyControlName authenticator is activated");
            }
        } catch (Throwable e) {
            log.fatal("Error while activating the MoneyControlName authenticator ", e);
        }
    }

    @Deactivate
    protected void deactivate(ComponentContext ctxt) {
        if (log.isDebugEnabled()) {
            log.debug("MoneyControlName authenticator is deactivated");
        }
    }
}
