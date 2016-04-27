package io.pivotal.microservices.music;

import javax.persistence.Id;

/**
 * @author zhengyu
 * @date 2016年4月24日
 */
public class Music {
    private String title;
    public static Long nextId = 0L;
    @Id
    protected Long id;
    
    protected static Long getNextId() {
        synchronized (nextId) {
            return nextId++;
        }
    }
    
    public Music(String title) {
        id = getNextId();
        this.title = title;
    }
    
    @Override
    public String toString() {
        return "The movie name: " + title;
    }
}
