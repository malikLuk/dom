package ru.dom.lukmanovcarhiring.app.registr_auth.dao;

import ru.dom.lukmanovcarhiring.app.dto.UserDto;
import ru.dom.lukmanovcarhiring.app.registr_auth.dao.entity.UserEntity;
import ru.dom.lukmanovcarhiring.common.dao.CommonHibernateDAO;
import ru.dom.lukmanovcarhiring.common.dao.CommonParams;

public class RegistrationDao extends CommonHibernateDAO<CommonParams, UserEntity, UserDto> {
}
