package com.test.automationexercise.utils.data;

import com.github.javafaker.Faker;

public class TestDataFactory {

    private TestDataFactory() {

    }

    public static UserData createValidUser() {
        Faker faker = new Faker();
        UserData userData = new UserData();

        //Test password, not real credential
        userData.password = "Test123!";
        userData.day = "15";
        userData.month = "10";
        userData.year = "2000";
        userData.firstName = faker.name().firstName();
        userData.lastName = faker.name().lastName();
        userData.address = faker.address().streetAddress();
        userData.country = "Australia";
        userData.city = faker.address().cityName();
        userData.state = faker.address().state();
        userData.zipcode = faker.address().zipCode();
        userData.mobileNumber = faker.phoneNumber().cellPhone();
        userData.email = faker.internet().emailAddress();

        return userData;
    }
}
