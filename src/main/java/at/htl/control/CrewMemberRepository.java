package at.htl.control;

import at.htl.model.BoatType;
import at.htl.model.CrewMember;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

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

}
