package ru.dom.lukmanovcarhiring.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.dom.lukmanovcarhiring.app.dao.ReservationDao;
import ru.dom.lukmanovcarhiring.app.dao.entity.ReservationEntity;
import ru.dom.lukmanovcarhiring.app.dto.ReservationDto;
import ru.dom.lukmanovcarhiring.app.params.ReservationParams;
import ru.dom.lukmanovcarhiring.common.dao.CommonHibernateDAO;
import ru.dom.lukmanovcarhiring.common.service.CommonService;

@Service
public class ReservationService extends CommonService<ReservationParams, ReservationEntity, ReservationDto>{

  @Autowired
  private final CommonHibernateDAO<ReservationParams, ReservationEntity, ReservationDto> dao;

  public ReservationService(@Qualifier(ReservationDao.DAO_NAME) CommonHibernateDAO<ReservationParams, ReservationEntity, ReservationDto> dao) {
    this.dao = dao;
  }

  @Override
  public CommonHibernateDAO<ReservationParams, ReservationEntity, ReservationDto> getDao() {
    return dao;
  }

  public void reserve() {
    dao.reserve();
  }

}
