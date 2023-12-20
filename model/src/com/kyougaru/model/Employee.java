package com.kyougaru.model;

sealed public interface Employee permits Developer, Manager {
    String name();
    double calculateSalary();
}
