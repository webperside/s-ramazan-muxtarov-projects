package com.company.librarywebappspring.service.impl;

import com.company.librarywebappspring.models.UserBook;
import com.company.librarywebappspring.repository.UserBookRepository;
import com.company.librarywebappspring.service.inter.UserBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserBookServiceImpl implements UserBookService {

    private final UserBookRepository userBookRepository;

    @Override
    public List<UserBook> findAllByUserId(Integer userId) {
        return userBookRepository.findAllByUserId(userId);
    }
}
