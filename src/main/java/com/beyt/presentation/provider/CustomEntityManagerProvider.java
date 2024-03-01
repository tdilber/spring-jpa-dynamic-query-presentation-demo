package com.beyt.presentation.provider;

import com.beyt.presentation.context.DBSelectionContext;
import com.beyt.jdq.provider.IEntityManagerProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.support.ScopeNotActiveException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class CustomEntityManagerProvider implements IEntityManagerProvider {
    @Autowired
    private DBSelectionContext dbSelectionContext;
    @Autowired
//    @Qualifier("entityManagerWrite")
    private EntityManager entityManager;

//    @Autowired
//    @Qualifier("entityManagerReadOnly")
//    private EntityManager entityManagerREADONLY;

    @Override
    public EntityManager provide() {
        try {
            if (DBSelectionContext.Database.READ.equals(dbSelectionContext.getDatabase())) {
    //            return entityManagerREADONLY;
            }
        } catch (ScopeNotActiveException e) {
            // ignore
        }

        return entityManager;
    }
}
