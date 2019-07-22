package com.zoo.zooApplication.application.filter;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.zoo.zooApplication.firebaseadaptor.FirebaseAuthImpl;
import com.zoo.zooApplication.firebaseadaptor.IFirebaseAuth;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.core.Ordered;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

// TODO: need to find away to test, since can't mock the Token
@FirebaseAuthentication // use for method name binding
@Provider
@Priority(Ordered.LOWEST_PRECEDENCE)
@ConditionalOnBean(FirebaseAuth.class)
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
                requestContext.setProperty(IFirebaseAuth.NAME, new FirebaseAuthImpl(token));
            } catch (FirebaseAuthException e) {
                e.printStackTrace();
            }
            // FIXME: should throw exception if token not set
        }
    }
}
