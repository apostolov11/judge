package com.softuni.service;

import com.softuni.model.entity.Exercise;
import com.softuni.model.service.ExerciseServiceModel;

import java.util.List;

public interface ExerciseService {

    void addEx(ExerciseServiceModel exerciseServiceModel);

    List<String> findAllExNames();

    boolean checkIfIsLate(String exercise);

    Exercise findByName(String name);
}
