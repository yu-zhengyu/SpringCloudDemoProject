package io.pivotal.microservices.movie;

import javax.persistence.Id;

/**
 * @author zhengyu
 * @date 2016年4月24日
 */
public class Movie {
    private String moviename;
    public static Long nextId = 0L;
    @Id
    protected Long id;
    
    protected static Long getNextId() {
        synchronized (nextId) {
            return nextId++;
        }
    }
    
    public Movie(String moviename) {
        id = getNextId();
        this.moviename = moviename;
    }
    
    @Override
    public String toString() {
        return "The movie name: " + moviename;
    }
}
