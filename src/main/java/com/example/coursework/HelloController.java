package com.example.coursework;



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HelloController {

    @FXML
    private ToggleGroup answers;

    @FXML
    private Text question_text;

    @FXML
    private RadioButton radio_btn_1;

    @FXML
    private RadioButton radio_btn_2;

    @FXML
    private RadioButton radio_btn_3;

    @FXML
    private RadioButton radio_btn_4;





    @FXML
    private Button answerBtn;

    private Questions[] questions = new Questions[]
            {
                    new Questions("Как вывести информацию на экран?", new String[] {"Console.Write()", "console.log()", "print()", "System.out.println()"}),
                    new Questions("Какой тип данных отвечает за целые числа?", new String[] {"String", "Float", "Boolean", "Integer"}),
                    new Questions("Как правильно объявить многомерный массив", new String[] {"a(0)(0) = 1;", "a[0 0] = 1;", "a{0}{0} = 1;", "a[0][0] = 1;"}),
                    new Questions("Какой метод запускает программу?", new String[] {"Основного метода нет", "Первый объявленный метод", "Любой, конкретного метода нету", "С метода main в любом из классов"}),
                    new Questions("Каждый файл должен иметь название", new String[] {"Соответствующий первой подключенной библиотеке", "Соответствующий первой функции", "Соответсвующий типам данных, хранящихся в нем", "Соответствующий имени класса, хранящегосяв нем"}),
                    new Questions("Сколько параметров может принимать функция?", new String[] {"Десять", "В Java функции не принимают параметров", "Пять", "Количество не определено"})
            };

    private int nowQuestion = 0, correctAnswers;
    private String nowCorrectAnswer;

    @FXML
    public void initialize()
    {
        nowCorrectAnswer = questions[nowQuestion].correctAnswer();

        answerBtn.setOnAction(e -> {
            RadioButton selectedRadioButton = (RadioButton) answers.getSelectedToggle();
            if(selectedRadioButton != null) {
                String toogleGroupValue = selectedRadioButton.getText();

                if(toogleGroupValue.equals(nowCorrectAnswer)) {
                    System.out.println("Верный ответ");
                    correctAnswers++;
                } else {
                    System.out.println("Не верный ответ");
                }

                // Это был последний вопрос
                if(nowQuestion + 1 == questions.length) {
                    radio_btn_1.setVisible(false);
                    radio_btn_2.setVisible(false);
                    radio_btn_3.setVisible(false);
                    radio_btn_4.setVisible(false);
                    answerBtn.setVisible(false);

                    question_text.setText("Вы правильно ответили на " + correctAnswers + " из " + questions.length + " вопросов!");
                } else {
                    nowQuestion++;
                    nowCorrectAnswer = questions[nowQuestion].correctAnswer();

                    question_text.setText(questions[nowQuestion].getQuestion());
                    String[] answers = questions[nowQuestion].getAnswers();


                    List<String> intList = Arrays.asList(answers);

                    Collections.shuffle(intList);

                    radio_btn_1.setText(intList.get(0));
                    radio_btn_2.setText(intList.get(1));
                    radio_btn_3.setText(intList.get(2));
                    radio_btn_4.setText(intList.get(3));

                    selectedRadioButton.setSelected(false);
                }

            }
        });
    }

}
