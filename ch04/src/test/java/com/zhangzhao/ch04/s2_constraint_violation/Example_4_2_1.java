package com.zhangzhao.ch04.s2_constraint_violation;

import com.zhangzhao.ch04.s2_constraint_violation.core.NotEmpty;
import java.util.Iterator;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Path.Node;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

public class Example_4_2_1 {

  @Test
  public void name() {
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    Author author = new Author();
    author.setCompany("ACME");
    Book book = new Book();
    book.setTitle("");
    book.setAuthor(author);

    Set<ConstraintViolation<Book>> constraintViolations = validator.validate(book);
    Iterator<ConstraintViolation<Book>> iterator = constraintViolations.iterator();
    verifyFirst(iterator, book);
    verifySecond(iterator, book);
  }

  private void verifyFirst(Iterator<ConstraintViolation<Book>> iterator, Book book) {
    ConstraintViolation<Book> constraintViolation = iterator.next();

    assert "may not be null or empty".equals(constraintViolation.getMessage());
    assert book == constraintViolation.getRootBean();
    assert book == constraintViolation.getLeafBean();
    assert book.getTitle().equals(constraintViolation.getInvalidValue());
    Iterator<Node> nodeIter = constraintViolation.getPropertyPath().iterator();
    assert "title".equals(nodeIter.next().getName());
    assert !nodeIter.hasNext();
  }

  private void verifySecond(Iterator<ConstraintViolation<Book>> iterator, Book book) {
    ConstraintViolation<Book> constraintViolation = iterator.next();

    assert "lastname must not be null".equals(constraintViolation.getMessage());
    assert book == constraintViolation.getRootBean();
    assert book.getAuthor() == constraintViolation.getLeafBean();
    assert book.getAuthor().getLastName() == constraintViolation.getInvalidValue();
    Iterator<Node> nodeIter = constraintViolation.getPropertyPath().iterator();
    assert "author".equals(nodeIter.next().getName());
    assert "lastName".equals(nodeIter.next().getName());
    assert !nodeIter.hasNext();
  }

  @Setter
  @Getter
  private static class Author {

    private String firstName;
    @NotEmpty(message = "lastname must not be null")
    private String lastName;
    @Size(max = 30)
    private String company;
  }

  @Setter
  @Getter
  private static class Book {

    @NotEmpty
    private String title;
    @Valid
    @NotNull
    private Author author;
  }
}
