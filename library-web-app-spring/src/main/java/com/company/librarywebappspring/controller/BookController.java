package com.company.librarywebappspring.controller;

import com.company.librarywebappspring.models.Book;
import com.company.librarywebappspring.models.User;
import com.company.librarywebappspring.security.CustomUserDetail;
import com.company.librarywebappspring.service.inter.BookService;
import com.company.librarywebappspring.util.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.company.librarywebappspring.util.UserUtils.currentUser;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @RequestMapping(value = "/books", method= RequestMethod.GET)
    public ModelAndView books(@RequestParam(value = "search", required = false) String search,
                              @RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "msg", required = false) String msg){

        User user = currentUser();

        String fullName = null;

        if(user != null) fullName = user.getName() + " " + user.getSurname();

        List<Book> books = bookService.findAll(search);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("books");
        mv.addObject("books",books);
        mv.addObject("userLoggedIn",fullName);
        mv.addObject("isAdmin", UserUtils.isAdmin());
        mv.addObject("error",error);
        mv.addObject("msg",msg);
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

    @RequestMapping(value = "/buy-book", method= RequestMethod.GET)
    public ModelAndView buyBookGet(@RequestParam(name="id") Integer id,
                                      ModelAndView mv){
        Book book = bookService.findById(id);
        mv.setViewName("buy-book");
        mv.addObject("book",book);
        return mv;
    }

    @RequestMapping(value = "/buy-book-path-variable/{id}", method= RequestMethod.GET)
    public ModelAndView buyBookGetPathVariable(@PathVariable(name="id") Integer id,
                                   ModelAndView mv){

        // @RequestParam vs @PathVariable
        // /books?id=1
        // /books/1

        Book book = bookService.findById(id);
        mv.setViewName("buy-book");
        mv.addObject("book",book);
        return mv;
    }

    @PostMapping("/buy-book")
    public ModelAndView buyBookPost(Integer id){
        String url;
        if(bookService.buyBook(id)){
            url = "redirect:/books?msg=Operation successful";
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
