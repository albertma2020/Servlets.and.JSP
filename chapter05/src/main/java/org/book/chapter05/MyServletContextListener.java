package org.book.chapter05;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Инициализация ServletContext происходит до инициализации сервлетов.
 * Так что объект собаки будет создан до инициализации сервлетов, и может
 * быть использован в контексте веб-приложения
 */

public class MyServletContextListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext sc = event.getServletContext();
        // получаем параметр инициализации из общего контекста
        String dogBreed = sc.getInitParameter("breed");
        String catName = sc.getInitParameter("catname");
        // создаем новый объект собаки
        Dog dog = new Dog(dogBreed);
        Cat cat = new Cat(catName);
        // добавляем новый атррибут объекта собаки к контексту
        sc.setAttribute("dog", dog);
        sc.setAttribute("cat", cat);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {

    }
}
