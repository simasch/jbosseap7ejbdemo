package ch.simas.demo;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;

@Stateless
@LocalBean
public class NewSessionBean implements NewSession {

    @Resource
    private SessionContext sessionContext;

    @Override
    @RolesAllowed({"users"})
    public String getPrincipalName() {
        return sessionContext.getCallerPrincipal().getName();
    }

}
