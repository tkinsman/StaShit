package edu.matc.service;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

//Defines the base URI for all resource URIs.
@ApplicationPath("/")

/**
 *
 *  The Application class for the RESTful api part of the application
 *
 * Created by toddkinsman on 10/26/16.
 */
public class StashitApplication extends Application {

    /**
     *
     * @return
     */
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(UserService.class );
        return h;
    }
}
