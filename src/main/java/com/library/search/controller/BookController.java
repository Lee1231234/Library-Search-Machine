package com.library.search.controller;

import com.library.search.dto.request.BookRequestDto;
import com.library.search.dto.response.BookResponseDto;
import com.library.search.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BookController {
    private final BookService bookService;

    @GetMapping("/")
    public String main(Model model){

        return "main";
    }

    @GetMapping("search")
    public String getBook(@RequestParam() String name,@RequestParam() String type, Model model){
        List<BookResponseDto> bookList =  bookService.getBook(name);
        System.out.println(bookList.size());
        model.addAttribute("bookList", bookList);
        return "main";
    }

    @PostMapping("api/book")
    public ResponseEntity<?> createBook(@RequestBody BookRequestDto requestDto){
        System.out.println(requestDto.getTitle());
        return bookService.createBook(requestDto);
    }
}
