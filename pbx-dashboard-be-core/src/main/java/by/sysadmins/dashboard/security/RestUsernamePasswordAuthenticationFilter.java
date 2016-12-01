package by.sysadmins.dashboard.security;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RestUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private JsonObject jsonObject;

    @Override
    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }

        if (request.getHeader("Content-Type").contains("application/json")) {
            getJsonObject(request);
        }
        String username = obtainUsername(request);
        String password = obtainPassword(request);

        if (username == null) {
            username = "";
        }

        if (password == null) {
            password = "";
        }

        username = username.trim();

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                username, password);

        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }

    @Override
    protected String obtainPassword(HttpServletRequest request) {
        String passwordParameter = SPRING_SECURITY_FORM_PASSWORD_KEY;
        if (request.getHeader("Content-Type").contains("application/json")) {
            return this.jsonObject.get(passwordParameter).getAsString();
        } else {
            return request.getParameter(passwordParameter);
        }
    }

    @Override
    protected String obtainUsername(HttpServletRequest request) {
        String usernameParameter = SPRING_SECURITY_FORM_USERNAME_KEY;
        if (request.getHeader("Content-Type").contains("application/json")) {
            return this.jsonObject.get(usernameParameter).getAsString();
        } else {
            return request.getParameter(usernameParameter);
        }
    }

    private void getJsonObject(HttpServletRequest request) {
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = null;
        try {
            jsonObject = jsonParser.parse(request.getReader()).getAsJsonObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.jsonObject = jsonObject;
    }
}
