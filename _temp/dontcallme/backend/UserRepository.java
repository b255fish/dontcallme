package com.practice.dontcallme.backend;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, String> {

    //// JpaRepository<User, String>
//    User findByEmailIgnoreCase(String email);
//
//    Page<User> findBy(Pageable pageable);
//
//    Page<User> findByEmailLikeIgnoreCaseOrFirstNameLikeIgnoreCaseOrLastNameLikeIgnoreCaseOrRoleLikeIgnoreCase(
//            String emailLike, String firstNameLike, String lastNameLike, String roleLike, Pageable pageable);
//
//    long countByEmailLikeIgnoreCaseOrFirstNameLikeIgnoreCaseOrLastNameLikeIgnoreCaseOrRoleLikeIgnoreCase(
//            String emailLike, String firstNameLike, String lastNameLike, String roleLike);


    /*
    org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'requestMappingHandlerAdapter' defined in class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]: Unsatisfied dependency expressed through method 'requestMappingHandlerAdapter' parameter 1; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'mvcConversionService' defined in class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.format.support.FormattingConversionService]: Factory method 'mvcConversionService' threw exception; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'userRepository': Invocation of init method failed; nested exception is java.lang.IllegalArgumentException: Failed to create query for method public abstract org.springframework.data.domain.Page com.practice.dontcallme.backend.UserRepository.findByEmailLikeIgnoreCaseOrFirstNameLikeIgnoreCaseOrLastNameLikeIgnoreCaseOrRoleLikeIgnoreCase(java.lang.String,java.lang.String,java.lang.String,java.lang.String,org.springframework.data.domain.Pageable)! No property firstName found for type User!

    * Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'userRepository': Invocation of init method failed; nested exception is java.lang.IllegalArgumentException: Failed to create query for method public abstract org.springframework.data.domain.Page com.practice.dontcallme.backend.UserRepository.findByEmailLikeIgnoreCaseOrFirstNameLikeIgnoreCaseOrLastNameLikeIgnoreCaseOrRoleLikeIgnoreCase(java.lang.String,java.lang.String,java.lang.String,java.lang.String,org.springframework.data.domain.Pageable)! No property firstName found for type User!

     * */
}
