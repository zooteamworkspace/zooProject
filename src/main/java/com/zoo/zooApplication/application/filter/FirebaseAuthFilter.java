package com.zoo.zooApplication.application.filter;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.servlet.annotation.WebFilter;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Component
@Provider
@ConditionalOnWebApplication
@Priority(Integer.MAX_VALUE) // run last
public class FirebaseAuthFilter implements ContainerRequestFilter {

    private FirebaseAuth firebaseAuth;

    private static final String HEADER_NAME = "X-Authorization-Firebase";

    @Inject
    public FirebaseAuthFilter(FirebaseAuth firebaseAuth) {
        this.firebaseAuth = firebaseAuth;
    }

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String firebaseHeader = requestContext.getHeaderString(HEADER_NAME);
        if (StringUtils.isNotBlank(firebaseHeader)) {
            try {
                FirebaseToken token = firebaseAuth.verifyIdToken(firebaseHeader);
                UserRecord userRecord = firebaseAuth.getUser(token.getUid());
                requestContext.setProperty("TEST", userRecord);
            } catch (FirebaseAuthException e) {
                e.printStackTrace();
            }
        }


    }
}
