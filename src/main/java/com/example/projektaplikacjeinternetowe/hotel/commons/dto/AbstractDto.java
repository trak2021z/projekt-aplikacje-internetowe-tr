package com.example.projektaplikacjeinternetowe.hotel.commons.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbstractDto<T> {

    private T id;
}
