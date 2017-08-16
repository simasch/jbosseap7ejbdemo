package ch.simas.demo;

import javax.ejb.Remote;

@Remote
public interface NewSession {

    String getPrincipalName();
}
