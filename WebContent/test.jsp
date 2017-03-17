<%@page import="hostel.service.BookService"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");

BookService bsBookService=(BookService) applicationContext.getBean("bookservice");

bsBookService.getAvailableBook();


%>