package com.example.springbootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@Slf4j
public class BookController {

//    @Autowired
//    private ESBookRepository esBookRepository;
//
//    @PostMapping
//    public String addBook(@RequestBody Book book) {
//        Book result = esBookRepository.save(book);
//        System.out.println(result);
//        return "success";
//    }
//
//    @GetMapping("/titleorauthor")
//    public List<Book> searchBook(String keyword){
//        log.info("searchBook start");
//        return esBookRepository.findByTitleOrAuthor(keyword, keyword);
//    }
//
//    @GetMapping("/find")
//    public SearchHits<Book> searchBook1(String keyword){
//        log.info("searchBook1 start");
//        return esBookRepository.find(keyword);
//    }

}
