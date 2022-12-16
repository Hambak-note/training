package me.code_manipulation;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookServiceTest {


    @Autowired BookService bookService;

    @Test
    public void di(){
        Assert.assertNotNull(bookService);
        Assert.assertNotNull(bookService.bookRepository);
    }
}