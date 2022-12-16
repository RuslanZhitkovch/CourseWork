
package com.example.coursework;
import javafx.beans.property.*;



public class QuestionProperty
{
    private final SimpleIntegerProperty id_question;
    private final SimpleStringProperty question;
    private final SimpleStringProperty answer1;
    private final SimpleStringProperty answer2;
    private final SimpleStringProperty answer3;
    private final SimpleStringProperty answer4;
    private final SimpleStringProperty correct_answer;
    private final SimpleIntegerProperty job_title_code;


    public QuestionProperty(Question question1)
    {
        id_question = new SimpleIntegerProperty(question1.getId_question());
        question = new SimpleStringProperty(question1.getQuestion());
        answer1 = new SimpleStringProperty(question1.getAnswer1());
        answer2 = new SimpleStringProperty(question1.getAnswer2());
        answer3 = new SimpleStringProperty(question1.getAnswer3());
        answer4 = new SimpleStringProperty(question1.getAnswer4());
        correct_answer = new SimpleStringProperty(question1.getCorrect_answer());
        job_title_code = new SimpleIntegerProperty(question1.getJob_title_code());

    }


    public int getId_question() {
        return id_question.get();
    }

    public SimpleIntegerProperty id_questionProperty() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question.set(id_question);
    }

    public String getQuestion() {
        return question.get();
    }

    public SimpleStringProperty questionProperty() {
        return question;
    }

    public void setQuestion(String question) {
        this.question.set(question);
    }

    public String getAnswer1() {
        return answer1.get();
    }

    public SimpleStringProperty answer1Property() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1.set(answer1);
    }

    public String getAnswer2() {
        return answer2.get();
    }

    public SimpleStringProperty answer2Property() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2.set(answer2);
    }

    public String getAnswer3() {
        return answer3.get();
    }

    public SimpleStringProperty answer3Property() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3.set(answer3);
    }

    public String getAnswer4() {
        return answer4.get();
    }

    public SimpleStringProperty answer4Property() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4.set(answer4);
    }

    public String getCorrect_answer() {
        return correct_answer.get();
    }

    public SimpleStringProperty correct_answerProperty() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer.set(correct_answer);
    }

    public int getJob_title_code() {
        return job_title_code.get();
    }

    public SimpleIntegerProperty job_title_codeProperty() {
        return job_title_code;
    }

    public void setJob_title_code(int job_title_code) {
        this.job_title_code.set(job_title_code);
    }
}
