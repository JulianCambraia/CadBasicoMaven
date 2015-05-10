/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.julianfernando.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.hibernate.Session;

/**
 * Esta classe executa os phaseListener em todas as fases do JSF
 * @author julian
 */
public class PhaseListenerCadBasico implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent fase) {
        // tentando restaurar a visão
        if (fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
            System.out.println("Depois da fase: " + getPhaseId());
            // inicia a transação e seta a sessão
            Session session = FacesContextUtil.getRequestSession();  
            try {
                session.getTransaction().commit();
                
            } catch (Exception e) {
                // algo de errado aconteceu e a sessão ainda está ativa
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } finally {
                session.close();
            }
            
        }
    }
 
    @Override
    public void beforePhase(PhaseEvent fase) {
         // tentando restaurar a visão
        if (fase.getPhaseId().equals(PhaseId.RESTORE_VIEW)) {
            System.out.println("antes da fase: " + getPhaseId() );
            
            // inicia a transação e seta a sessão
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            FacesContextUtil.setRequestSession(session);  
        }
    }
    
    // retorna todas as fases do JSF em que a sessão estiver
    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

    
}
