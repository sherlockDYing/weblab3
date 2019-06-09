package com.lab3.demo.response;

public class GreetingResponse {
    private final long id;
    private final String name;

    public GreetingResponse(long id,String name) {
       this.id = id;
       this.name = name;
    }

    public long getId(){
        return id;
    }
    public String getName() {
        return name;
    }
}
