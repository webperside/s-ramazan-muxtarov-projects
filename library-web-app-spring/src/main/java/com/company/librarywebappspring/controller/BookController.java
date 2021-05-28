package com.company.librarywebappspring.controller;

import com.company.librarywebappspring.models.Book;
import com.company.librarywebappspring.security.CustomUserDetail;
import com.company.librarywebappspring.service.inter.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @RequestMapping(value = "/books", method= RequestMethod.GET)
    public ModelAndView books(@RequestParam(value = "search", required = false) String search){

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String fullName = null;
        if(principal instanceof UserDetails){
            CustomUserDetail userDetail = (CustomUserDetail) principal;
            fullName = userDetail.getUser().getName() + " " + userDetail.getUser().getSurname();
        }

        List<Book> books = bookService.findAll(search);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("books");
        mv.addObject("books",books);
        mv.addObject("userLoggedIn",fullName);
        return mv;
    }

    @RequestMapping(value = "/book-add", method= RequestMethod.GET)
    public ModelAndView bookAddGet(){
        return new ModelAndView("book-add");
    }

    @RequestMapping(value = "/book-add", method= RequestMethod.POST)
    public ModelAndView bookAddPost(Book book){
        bookService.save(book);
        return new ModelAndView("redirect:/books");
    }

    @RequestMapping(value = "/book-edit", method= RequestMethod.GET)
    public ModelAndView bookEditGet(@RequestParam(name="id") Integer id,
                                    ModelAndView mv){
        Book book = bookService.findById(id);
        mv.setViewName("book-edit");
        mv.addObject("book",book);
        return mv;
    }

    @RequestMapping(value = "/book-edit", method= RequestMethod.POST)
    public ModelAndView bookEditPost(Book book){
        String url;
        if (bookService.update(book)) {
            url = "redirect:/books";
        } else {
            url = "redirect:/books?error=Book not found";
        }
        return new ModelAndView(url);
    }

    @RequestMapping(value = "/book-delete", method= RequestMethod.GET)
    public ModelAndView bookDeleteGet(@RequestParam(name="id") Integer id,
                                      ModelAndView mv){
        Book book = bookService.findById(id);
        mv.setViewName("book-delete");
        mv.addObject("book",book);
        return mv;
    }

    @RequestMapping(value = "/book-delete", method= RequestMethod.POST)
    public ModelAndView bookDeletePost(Integer id){
        String url;
        if (bookService.remove(id)) {
            url = "redirect:/books";
        } else {
            url = "redirect:/books?error=Book not found";
        }
        return new ModelAndView(url);
    }

//    @RequestMapping(value = "/book-add", method= RequestMethod.POST)
//    public ModelAndView bookAddPost(@RequestParam("name") String name,
//                                    @RequestParam("description") String description,
//                                    @RequestParam("author") String author,
//                                    @RequestParam("price") String price,
//                                    @RequestParam("stockCount") String stockCount){
//
//    }

}
