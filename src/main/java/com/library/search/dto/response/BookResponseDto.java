package com.library.search.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BookResponseDto {
    private Long id;
    private String title;

    private String writer;

    private String publisher;

    private Integer yearOfIssue;

    private Long isbn;
}
