package com.huynhcanh.commonservice.advide;

import com.huynhcanh.commonservice.common.CommonException;
import com.huynhcanh.commonservice.common.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.security.oauthbearer.secured.ValidateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
@Slf4j
public class ExceptionAdvide {

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> handleCommonException(CommonException ex){
        log.error(String.format("Common error: %s %s %s", ex.getCode(), ex.getStatus(),ex.getMessage()));
        return new ResponseEntity(new ErrorMessage(ex.getCode(), ex.getMessage(),ex.getStatus()),ex.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> handleException(Exception ex){
        log.error("Unknown internal server error: "+ex.getMessage());
        log.error("Exception class: "+ex.getClass());
        log.error("Exception cause: "+ex.getCause());
        return new ResponseEntity(new ErrorMessage("9999", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
