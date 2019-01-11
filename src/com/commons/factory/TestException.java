package com.commons.factory;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.ACCEPTED,reason ="自定义错误")
public class TestException extends  Exception{

}
