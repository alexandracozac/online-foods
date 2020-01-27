package org.fasttrackit.onlinefoods.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourseNotFoundException extends ApplicationException {
    public ResourseNotFoundException(String message) {
        super(message, ErrorCode.NOT_FOUND);
    }
}
