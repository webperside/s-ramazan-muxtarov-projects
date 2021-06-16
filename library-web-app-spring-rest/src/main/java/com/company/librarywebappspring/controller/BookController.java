package com.company.librarywebappspring.controller;

import com.company.librarywebappspring.dto.ResponseDto;
import com.company.librarywebappspring.dto.books.BookByIdDto;
import com.company.librarywebappspring.dto.books.BookCreateUpdateDto;
import com.company.librarywebappspring.dto.books.BookListDto;
import com.company.librarywebappspring.service.inter.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    // /books/1 (GET, PUT, POST, DELETE)

    private final BookService bookService;

    @GetMapping
    public ResponseDto books(@RequestParam(value = "search", required = false) String search){
        List<BookListDto> books = bookService.findAll(search);
        return ResponseDto.builder().object(books).build();
    }

    @GetMapping("/{bookId}")
    public ResponseDto getById(@PathVariable("bookId") Integer bookId){
        BookByIdDto bookDto = bookService.findById(bookId);
        return ResponseDto.builder().object(bookDto).build();
    }

    @PostMapping
    public void save(@RequestBody BookCreateUpdateDto createUpdateDto){
        bookService.save(createUpdateDto);
    }

    @PutMapping("/{bookId}")
    public void update(@PathVariable("bookId") Integer bookId, @RequestBody BookCreateUpdateDto bookCreateUpdateDto){
        bookService.update(bookId, bookCreateUpdateDto);
    }

    @DeleteMapping("/{bookId}")
    public void delete(@PathVariable("bookId") Integer bookId){
        bookService.remove(bookId);
    }

//
//    @RequestMapping(value = "/book-edit", method= RequestMethod.GET)
//    public ModelAndView bookEditGet(@RequestParam(name="id") Integer id,
//                                    ModelAndView mv){
//
//        Book book = bookService.findById(id);
//        mv.setViewName("book-edit");
//        mv.addObject("book",book);
//
//        return mv;
//    }
//
//    @RequestMapping(value = "/book-edit", method= RequestMethod.POST)
//    public ModelAndView bookEditPost(Book book){
//        String url;
//        if (bookService.update(book)) {
//            url = "redirect:/books";
//        } else {
//            url = "redirect:/books?error=Book not found";
//        }
//        return new ModelAndView(url);
//    }
//
//    @RequestMapping(value = "/book-delete", method= RequestMethod.GET)
//    public ModelAndView bookDeleteGet(@RequestParam(name="id") Integer id,
//                                      ModelAndView mv){
//        Book book = bookService.findById(id);
//        mv.setViewName("book-delete");
//        mv.addObject("book",book);
//        return mv;
//    }
//
//    @RequestMapping(value = "/book-delete", method= RequestMethod.POST)
//    public ModelAndView bookDeletePost(Integer id){
//        String url;
//        if (bookService.remove(id)) {
//            url = "redirect:/books";
//        } else {
//            url = "redirect:/books?error=Book not found";
//        }
//        return new ModelAndView(url);
//    }
//
//    @RequestMapping(value = "/buy-book", method= RequestMethod.GET)
//    public ModelAndView buyBookGet(@RequestParam(name="id") Integer id,
//                                      ModelAndView mv){
//        Book book = bookService.findById(id);
//        mv.setViewName("buy-book");
//        mv.addObject("book",book);
//        return mv;
//    }
//
//    @RequestMapping(value = "/buy-book-path-variable/{id}", method= RequestMethod.GET)
//    public ModelAndView buyBookGetPathVariable(@PathVariable(name="id") Integer id,
//                                   ModelAndView mv){
//
//        // @RequestParam vs @PathVariable
//        // /books?id=1
//        // /books/1
//
//        Book book = bookService.findById(id);
//        mv.setViewName("buy-book");
//        mv.addObject("book",book);
//        return mv;
//    }
//
//    @PostMapping("/buy-book")
//    public ModelAndView buyBookPost(Integer id){
//        String url;
//        if(bookService.buyBook(id)){
//            url = "redirect:/books?msg=Operation successful";
//        } else {
//            url = "redirect:/books?error=Book not found";
//        }
//        return new ModelAndView(url);
//    }

//    @RequestMapping(value = "/book-add", method= RequestMethod.POST)
//    public ModelAndView bookAddPost(@RequestParam("name") String name,
//                                    @RequestParam("description") String description,
//                                    @RequestParam("author") String author,
//                                    @RequestParam("price") String price,
//                                    @RequestParam("stockCount") String stockCount){
//
//    }

}
