package br.com.julianfernando.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Classe que realiza o gerenciamento da conexão com o banco de dados
 * @author julian
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    // armazena a sessão do hibernate
    public static final String HIBERNATE_SESSION = "hibernate_session";

    static {
        try {
            System.out.println("Tentando abrir uma SF");
            Configuration configuration = new Configuration().configure();
            
            // pega o arquivo .cfg de configuração com o banco- arquivo este que fica na pasta resource
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            
           // Session session = sessionFactory.openSession();
            System.out.println("Session Factory criada com sucesso!!!.");
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao iniciar a SF." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
