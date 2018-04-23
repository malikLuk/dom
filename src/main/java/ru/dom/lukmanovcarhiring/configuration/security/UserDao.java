package ru.dom.lukmanovcarhiring.configuration.security;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.dom.lukmanovcarhiring.app.dto.UserDto;
import ru.dom.lukmanovcarhiring.app.registr_auth.dao.entity.UserEntity;

@Repository("userDao")
@Transactional
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public UserEntity findByFirstName(String firstName) {
        Criteria crit = getCriteria();
        crit.add(Restrictions.eq("firstName", firstName));
        UserEntity user = (UserEntity) crit.uniqueResult();
        if(user!=null){
            System.out.println(1);
        }
        return user;
    }

    protected Criteria getCriteria() {
        return this.sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
    }

    public void saveUser(UserDto user) {
        UserEntity userEntity = new UserEntity();
//        userEntity.setId(new Long(2));
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setPassword(user.getPassword());
        userEntity.setRole("USER");
        this.sessionFactory.getCurrentSession().persist(userEntity);
    }

}
