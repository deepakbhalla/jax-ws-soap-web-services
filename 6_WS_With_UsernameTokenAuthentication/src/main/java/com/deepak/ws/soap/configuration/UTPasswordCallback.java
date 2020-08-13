package com.deepak.ws.soap.configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class UTPasswordCallback implements CallbackHandler {

    // In memory storage
    private Map<String, String> passwords = new HashMap<>();

    /**
     * Clients should use these username and passwords while calling this
     * web-service. In realtime, this information can be fetched from any database
     * or LDAP server.
     */
    public UTPasswordCallback() {
        passwords.put("deepakUsername", "bhallaPassword"); // key:value = "deepakUsername:bhallaPassword"
        passwords.put("cxf", "cxf-rt-ws-security-pwd"); // key:value = "cxf:cxf-rt-ws-security-pwd"
    }

    /**
     * These callbacks[] have usernames which comes in the request. We need to find
     * the matching username and set the password on this callback
     */
    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {

        for (Callback callback : callbacks) {
            WSPasswordCallback passwordCallback = (WSPasswordCallback) callback;
            String username = passwordCallback.getIdentifier(); // Get username in the request callback
            String password = passwords.get(username);

            if (password != null) {
                passwordCallback.setPassword(password);
                return; // Generally only one username/password is present in the callback.
            }
        }
    }

}
