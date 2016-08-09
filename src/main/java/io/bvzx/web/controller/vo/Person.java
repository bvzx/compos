package io.bvzx.service.web.controller.vo;

import java.util.Optional;

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

    private Optional<String> userName;
    private Optional<Integer> age;
    private Optional<String> province;
    private Optional<String> city;
    private Optional<Integer> hight;
    private Optional<Integer> weight;
    private Optional<String> look;

    public Optional<String> getUserName() {
        return userName;
    }

    public void setUserName(Optional<String> userName) {
        this.userName = userName;
    }

    public Optional<Integer> getAge() {
        return age;
    }

    public void setAge(Optional<Integer> age) {
        this.age = age;
    }

    public Optional<String> getProvince() {
        return province;
    }

    public void setProvince(Optional<String> province) {
        this.province = province;
    }

    public Optional<String> getCity() {
        return city;
    }

    public void setCity(Optional<String> city) {
        this.city = city;
    }

    public Optional<Integer> getHight() {
        return hight;
    }

    public void setHight(Optional<Integer> hight) {
        this.hight = hight;
    }

    public Optional<Integer> getWeight() {
        return weight;
    }

    public void setWeight(Optional<Integer> weight) {
        this.weight = weight;
    }

    public Optional<String> getLook() {
        return look;
    }

    public void setLook(Optional<String> look) {
        this.look = look;
    }
}
