package com.mycompany.process;

public class Process {
    private static int n_id = 0;
    private String name;
    private int priority;
    private int id;
    private float runtime;
    private int size_memory;

    public Process(String name, int priority, float runtime, int size_memory) {
        this.name = name;
        this.priority = priority;
        this.runtime = runtime;
        this.size_memory = size_memory;
        this.id = Process.n_id;
        Process.n_id++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getRuntime() {
        return runtime;
    }

    public void setRuntime(float runtime) {
        this.runtime = runtime;
    }

    public int getSize_memory() {
        return size_memory;
    }

    public void setSize_memory(int size_memory) {
        this.size_memory = size_memory;
    }
}
