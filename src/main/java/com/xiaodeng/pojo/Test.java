package com.xiaodeng.pojo;


import java.util.List;

public class Test {
    private Integer id;

    private Integer nums;

    private String mingzi;

    private List<String> inters;

    public Test(Integer nums, String mingzi, List<String> inters) {
        this.nums = nums;
        this.mingzi = mingzi;
        this.inters = inters;
    }

    public Test(Integer id, Integer nums, String name, List<String> inters) {
        this.id = id;
        this.nums = nums;
        this.mingzi = name;
        this.inters = inters;
    }

    public Test(Integer id, Integer nums, String name) {
        this.id = id;
        this.nums = nums;
        this.mingzi = name;
    }

    public Test() {

    }

    public List<String> getInters() {
        return inters;
    }

    public void setInters(List<String> inters) {
        this.inters = inters;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public String getName() {
        return mingzi;
    }

    public void setName(String name) {
        this.mingzi = name == null ? null : name.trim();
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", nums=" + nums +
                ", mingzi='" + mingzi + '\'' +
                ", inters=" + inters +
                '}';
    }
}