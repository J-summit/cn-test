package cn.lansky;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author onlyo
 * @since 2019/6/26 18:45
 */
public class BeanCopyUtils {

    private static final MapperFacade MAPPER_FACADE = new DefaultMapperFactory.Builder().mapNulls(false).build().getMapperFacade();


    private static final MapperFacade MAPPER_FACADE1 = new DefaultMapperFactory.Builder().build().getMapperFacade();


    public static <T> T copy(Object source, Class<T> target) {
        if (source == null) {
            return null;
        }
        return MAPPER_FACADE1.map(source, target);
    }

    public static <T> void copy(Object source, Object target) {

        MAPPER_FACADE.map(source, target);
    }

    public static <T> Collection<T> copyCollection(List<Object> objs, Class<T> clazz) {
        Collection<T> list = new ArrayList<>();
        for (int i = 0; i < objs.size(); i++) {
            if (objs.get(i) == null) {
                return null;
            }
            list.add(MAPPER_FACADE1.map(objs.get(i), clazz));
        }

        return list;
    }
}
