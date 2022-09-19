package com.library.search.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDto {
    private String title;

    private String writer;

    private String publisher;

    private Integer yearOfIssue;

    private Long isbn;
}
