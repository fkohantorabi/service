package com.sehron.service.rest.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/s")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    @ResponseBody
    public boolean start() {
        if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
            return false;
        }

        Authentication result = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken("user1",
                        "123"));

        SecurityContextHolder.getContext().setAuthentication(result);

        return true;
    }

    @RequestMapping(value = "/stop", method = RequestMethod.GET)
    @ResponseBody
    public boolean stop(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }

            SecurityContextHolder.clearContext();
        } catch (Exception e) {
        }

        return true;
    }
}
