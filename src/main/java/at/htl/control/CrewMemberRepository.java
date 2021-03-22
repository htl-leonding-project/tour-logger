package at.htl.control;

import at.htl.model.BoatType;
import at.htl.model.CrewMember;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CrewMemberRepository {

    @Inject
    EntityManager em;

    public void delete(CrewMember crewMember) {
        em.remove(crewMember);
    }

    public void save(CrewMember crewMember){
        em.merge(crewMember);
    }

    public List<CrewMember> findAll() {
        return em
                .createNamedQuery("CrewMember.findAll", CrewMember.class)
                .getResultList();
    }

}
