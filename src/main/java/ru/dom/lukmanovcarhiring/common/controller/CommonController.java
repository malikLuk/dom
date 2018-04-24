package ru.dom.lukmanovcarhiring.common.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dom.lukmanovcarhiring.common.dao.entity.CommonEntity;
import ru.dom.lukmanovcarhiring.common.params.CommonParams;
import ru.dom.lukmanovcarhiring.common.dto.CommonDto;
import ru.dom.lukmanovcarhiring.common.service.CommonService;

import java.util.List;
import java.util.Map;

public abstract class CommonController<P extends CommonParams, E extends CommonEntity, D extends CommonDto> {

    public abstract CommonService<P, E, D> getService();

    private Class<P> paramClass;
    private Class<E> entityClass;
    private Class<D> dtoClass;

    public CommonController() {
        final Class<?>[] resolveTypeArguments = GenericTypeResolver.resolveTypeArguments(getClass(), CommonController.class);
        this.paramClass = (Class<P>) resolveTypeArguments[0];
        this.entityClass = (Class<E>) resolveTypeArguments[1];
        this.dtoClass = (Class<D>) resolveTypeArguments[2];

    }

//    @RequestMapping(value = "/filter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<D> filter(Map<String, Object> model, P params) {
        return this.getService().filter(params);
    }

}