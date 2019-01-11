package com.Web.convert;

import com.commons.entity.User;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

        public class CustomMessage extends AbstractHttpMessageConverter<User>{
    /**
     * 设置支持的媒体类型
     * @return
     */
    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return Arrays.asList(MediaType.ALL);
    }

    /**
     * 当前类型的对象是否支持此转换器
     * @param clazz
     * @return
     */

    @Override
    protected boolean supports(Class <?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    protected User readInternal(Class <? extends User> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        System.out.println("测试");
        return new User();
    }
/*%s是字符串类型*/
    @Override
    protected void writeInternal(User user, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String msg=String.format("userName:%s,userPassword:%s",user.getUserName(),user.getUserPassword());
        outputMessage.getBody().write(msg.getBytes("UTF-8"));

    }
}
