package com.example.projektaplikacjeinternetowe.hotel.commons.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BadRequestException extends RuntimeException {

    private final ResponseMessage exceptionMessage;
}
