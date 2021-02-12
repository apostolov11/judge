package com.softuni.model.biding;

import javax.validation.constraints.Pattern;

public class HomeworkAddBindingModel {

    private String exercise;
    private String gitAddress;

    public HomeworkAddBindingModel() {
    }


    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    @Pattern(regexp = "https:\\/\\/github\\.com\\/.+",message = "Enter valid gid address!")
    public String getGitAddress() {
        return gitAddress;
    }

    public void setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
    }
}
