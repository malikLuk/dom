package ru.dom.lukmanovcarhiring.app.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.dom.lukmanovcarhiring.app.dao.entity.ReservationEntity;
import ru.dom.lukmanovcarhiring.app.dto.ReservationDto;
import ru.dom.lukmanovcarhiring.app.params.ReservationParams;
import ru.dom.lukmanovcarhiring.app.utils.Utilities;
import ru.dom.lukmanovcarhiring.common.dao.CommonHibernateDAO;
import ru.dom.lukmanovcarhiring.configuration.security.CustomUser;

import java.util.Date;

@Repository(value = ReservationDao.DAO_NAME)
public class ReservationDao extends CommonHibernateDAO<ReservationParams, ReservationEntity, ReservationDto> {

  public static final String DAO_NAME = "reservationDao";

  @Override
  protected void addRestrictions(Criteria criteria, ReservationParams params) {
    CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Long userId = user.getId();
    params.setUserId(userId);
    super.addRestrictions(criteria, params);
  }

  @Override
  @Transactional
  public void reserve(ReservationParams params) {
    Session session = this.getSessionFactory().getCurrentSession();
    ReservationEntity reservationDto = new ReservationEntity();
    reservationDto.setCarId(params.getCarId());
    reservationDto.setPickupDate(new Date());
    reservationDto.setPickupLocationId(params.getPickupLocationId());
    reservationDto.setUserId(Utilities.getUser().getId());
    session.save(reservationDto);
  }

}
