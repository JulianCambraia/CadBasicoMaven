package br.com.julianfernando.util;

import javax.faces.context.FacesContext;
import org.hibernate.Session;

/**
 *
 * @author julian
 */
public class FacesContextUtil {
    
    private static final String HIBERNATE_SESSION = "hibernete_session";

    public static Session getRequestSession() {
        return (Session)FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(HIBERNATE_SESSION);
    }
    
    /**
     *
     * @param session
     */
    public static void setRequestSession(Session session) {
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(HIBERNATE_SESSION, session);
    }
}
