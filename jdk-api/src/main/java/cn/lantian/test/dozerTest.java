package cn.lantian.test;

import com.github.dozermapper.core.DozerBeanMapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.github.dozermapper.core.loader.api.BeanMappingBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

import java.lang.ref.WeakReference;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author onlyo
 * @since 2019/6/5 16:56
 */
public class dozerTest {
    public static void main(String[] args) {
      //  Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        User user = new User();
        user.setLdt(LocalDateTime.now());
        user.setLd(LocalDate.now());
        user.setLt(LocalTime.now());

        List<Sour> sours = new ArrayList<>();
        sours.add(new Sour(1, "sours"));
        user.setSours(sours);

        LiDto liDto = new LiDto();
        liDto.setId(1);
        liDto.setName("liDto");
        user.setLiDto(liDto);

        UserDto test = new UserDto();
        test.setName("sdada");
        BeanUtils.copyProperties(user, test);
        user.setName("set");
       // mapper.map(user, test);
        System.out.println(test);
    }
//
//    public static void copyProperties(final Object sources, final Object destination) {
//        WeakReference weakReference = new WeakReference(new DozerBeanMapper());
//        DozerBeanMapper mapper = (DozerBeanMapper) weakReference.get();
//        mapper.addMapping(new BeanMappingBuilder() {


//            @Override
//            protected void configure() {
//                mapping(sources.getClass(), destination.getClass(), mapNull(false), mapEmptyString(false));
//            }
//        });
//        mapper.map(sources, destination);
//        mapper.destroy();
//        weakReference.clear();
//    }
}
