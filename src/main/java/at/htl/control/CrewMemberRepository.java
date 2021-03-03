package at.htl.control;

import at.htl.model.BoatType;
import at.htl.model.CrewMember;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class CrewMemberRepository {

    @Inject
    EntityManager em;

    @Transactional
    public void delete(CrewMember crewMember) {
        em.remove(crewMember);
    }

    @Transactional
    public void save(CrewMember crewMember){
        em.merge(crewMember);
    }

    public List<CrewMember> findAll() {
        return em
                .createNamedQuery("CrewMember.findAll", CrewMember.class)
                .getResultList();
    }

}
