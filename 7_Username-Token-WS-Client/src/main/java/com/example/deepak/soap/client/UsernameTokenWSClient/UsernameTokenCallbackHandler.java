package com.example.deepak.soap.client.UsernameTokenWSClient;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class UsernameTokenCallbackHandler implements CallbackHandler {

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {

        for (Callback callback : callbacks) {
            WSPasswordCallback wpc = (WSPasswordCallback) callback;
            if ("deepakUsername".equals(wpc.getIdentifier())) {
                wpc.setPassword("bhallaPassword");
                return;
            }
        }
    }

}
