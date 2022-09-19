package com.library.search.service;

import com.library.search.domain.Book;
import com.library.search.dto.request.BookRequestDto;
import com.library.search.dto.response.BookResponseDto;
import com.library.search.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;

    @Transactional
    public ResponseEntity<?> createBook(BookRequestDto requestDto){

        bookRepository.save(
                Book.builder()
                        .title(requestDto.getTitle())
                        .writer(requestDto.getWriter())
                        .publisher(requestDto.getPublisher())
                        .yearOfIssue(requestDto.getYearOfIssue())
                        .isbn(requestDto.getIsbn())
                        .build()
        );

        return ResponseEntity.ok("성공");
    }
    public List<BookResponseDto> getBook(String title){
        System.out.println(title);
        List<Book> bookList = bookRepository.findByTitleContaining(title);
        System.out.println(bookList.size());
        List<BookResponseDto> bookResponseDtoList = new ArrayList<>();
        for(Book book : bookList){
            bookResponseDtoList.add(
                    BookResponseDto.builder()
                            .id(book.getId())
                            .title(book.getTitle())
                            .writer(book.getWriter())
                            .publisher(book.getPublisher())
                            .yearOfIssue(book.getYearOfIssue())
                            .isbn(book.getIsbn())
                            .build()
            );
        }
        return bookResponseDtoList;
    }
}
