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
    super.addRestrictions(criteria, params);
  }

  @Override
  @Transactional
  public ReservationDto reserve(ReservationParams params) {
    Session session = this.getSessionFactory().getCurrentSession();
    ReservationEntity reservationEntity = new ReservationEntity();
    reservationEntity.setCarId(params.getCarId());
    reservationEntity.setPickupDate(new Date());
    reservationEntity.setPickupLocationId(params.getPickupLocationId());
    reservationEntity.setLocationAddress(params.getLocationAddress());
    reservationEntity.setUserId(Utilities.getUser().getId());
    session.save(reservationEntity);
    return this.modelMapper.map(reservationEntity, ReservationDto.class);
  }

  @Override
  @Transactional
  public ReservationDto giveBack(ReservationParams params) {
    if (params.getReturnLocationId() != null) {
      Session session = this.getSessionFactory().getCurrentSession();
      ReservationEntity reservationEntity = new ReservationEntity();
      reservationEntity.setCarId(params.getCarId());
      reservationEntity.setReturnDate(new Date());
      reservationEntity.setReturnLocationId(params.getReturnLocationId());
      reservationEntity.setLocationAddress(params.getLocationAddress());
      reservationEntity.setUserId(null);
      session.save(reservationEntity);
      return this.modelMapper.map(reservationEntity, ReservationDto.class);
    } else {
      return null;
    }
  }
}
