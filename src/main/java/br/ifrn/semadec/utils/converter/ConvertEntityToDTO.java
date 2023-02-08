package br.ifrn.semadec.utils.converter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.ifrn.semadec.entities.user.User;

public class ConvertEntityToDTO {

    protected ConvertEntityToDTO() {
        throw new IllegalStateException("Utility class");
    }

    public static Object convert(User user, Class<?> classDTO) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.convertValue(user, classDTO);
    }
}
