package com.example.coursework;
import java.io.Serializable;

public class Question implements Serializable {
    private Integer id_question;
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String correct_answer;
    private Integer job_title_code;


    public Question(Integer id_question, String question, String answer1, String answer2, String answer3, String answer4, String correct_answer, Integer job_title_code) {
        this.id_question = id_question;
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correct_answer = correct_answer;
        this.job_title_code = job_title_code;
    }

    public Question(String question, String answer1, String answer2, String answer3, String answer4, String correct_answer, Integer job_title_code) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correct_answer = correct_answer;
        this.job_title_code = job_title_code;
    }

    public Question()
    {}

    public Integer getId_question() {
        return id_question;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public Integer getJob_title_code() {
        return job_title_code;
    }

    public void setId_question(Integer id_question) {
        this.id_question = id_question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public void setJob_title_code(Integer job_title_code) {
        this.job_title_code = job_title_code;
    }
}

