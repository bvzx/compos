package io.bvzx.service.web.controller.vo;

/**
 * todo
 *
 * @author wugaoda
 * @Description: (类职责详细描述, 可空)
 * @ClassName: WinningRsult
 * @date 2016年07月01日 17:43
 * @Copyright (c) 2015-2020 by caitu99
 */
public class Person {


    /**
     * userName : bvzx
     * age : 20
     * province : 123
     * city : zhongguo
     * hight : 183
     * weight : 24
     * look : top
     */

    private String userName;
    private int age;
    private String province;
    private String city;
    private int hight;
    private int weight;
    private String look;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getLook() {
        return look;
    }

    public void setLook(String look) {
        this.look = look;
    }
}
