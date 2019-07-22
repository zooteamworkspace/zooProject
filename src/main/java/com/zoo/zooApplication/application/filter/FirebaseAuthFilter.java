package com.zoo.zooApplication.application.filter;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.zoo.zooApplication.firebaseadaptor.FirebaseAuthImpl;
import com.zoo.zooApplication.firebaseadaptor.IFirebaseAuth;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// TODO: need to find away to test, since can't mock the Token
public class FirebaseAuthFilter extends OncePerRequestFilter {

    private FirebaseAuth firebaseAuth;

    private static final String HEADER_NAME = "X-Authorization-Firebase";

    public FirebaseAuthFilter(FirebaseAuth firebaseAuth) {
        this.firebaseAuth = firebaseAuth;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String firebaseHeader = request.getHeader(HEADER_NAME);
        if (StringUtils.isNotBlank(firebaseHeader)) {
            try {
                FirebaseToken token = firebaseAuth.verifyIdToken(firebaseHeader);
                request.setAttribute(IFirebaseAuth.NAME, new FirebaseAuthImpl(token));
                filterChain.doFilter(request, response);
            } catch (FirebaseAuthException e) {
                e.printStackTrace();
            }
        }
        // FIXME: should throw exception if token not set
        filterChain.doFilter(request, response);
    }
}
