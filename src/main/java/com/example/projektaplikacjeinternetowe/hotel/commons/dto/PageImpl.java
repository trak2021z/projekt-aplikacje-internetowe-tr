package com.example.projektaplikacjeinternetowe.hotel.commons.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@RequiredArgsConstructor
public class PageImpl {

    private final int page;
    private final int size;
    private boolean sort;
    private String[] properties;
    private Sort.Direction direction = Sort.Direction.ASC;

    public Pageable buildPageable() {
        if (!sort) {
            return PageRequest.of(this.page, this.size);
        } else if (properties != null) {
            return PageRequest.of(this.page, this.size, direction, this.properties);
        } else {
            return PageRequest.of(this.page, this.size, direction, "id");
        }
    }
}
