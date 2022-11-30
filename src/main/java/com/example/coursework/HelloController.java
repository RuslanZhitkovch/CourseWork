package com.example.coursework;



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.example.coursework.chooseTestController.getJavaQuestions;
import static com.example.coursework.chooseTestController.getPythonQuestions;
import static com.example.coursework.chooseTestController.getCiPlusPlusQuestions;
import static com.example.coursework.chooseTestController.getDatabaseQuestions;
import static com.example.coursework.chooseTestController.getHrManagerQuestions;




public class HelloController {


    @FXML
    private Label currentQuizName;


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



    private int nowQuestion = 0, correctAnswers;
    private String nowCorrectAnswer;



    private Questions[] pythonQuestions = new Questions[]
            {       new Questions("Как ваше настроение?", new String[] {"Неважно", "Плохо", "Могло быть лучше", "Боевое" }),
                    new Questions("Как вывести информацию на экран?", new String[] {"Console.Write()", "console.log()", "System.out.println()", "print()" }),
                    new Questions("Переменная int:", new String[] {"Вещественная переменная", "Символьная строка", "Логическая переменная", "Целая переменная"}),
                    new Questions("Переменная float:", new String[] {"Целая переменная", "Логическая переменная", "Символьная строка", "Вещественная переменная;"}),
                    new Questions("Что будет выведено в результате следующего действия print(2**3)", new String[] {"5", "6", "-1", "8"}),
                    new Questions("Алгоритм, в котором действия выполняются в зависимости от истинности условия называется:", new String[] {"Линейный", "Нелинейный", "Циклический", "Разветвляющийся"}),
                    new Questions("Выберите оператор ввода:", new String[] {"print(x)", "x = 12", "x*5","x=input()"})
            };


    private Questions[] javaQuestions = new Questions[]
            {
                    new Questions("Как ваше настроение?", new String[] {"Не очень", "Плохо", "Могло быть лучше", "Боевое" }),
                    new Questions("Как вывести информацию на экран?", new String[] {"Console.Write()", "console.log()", "print()", "System.out.println()"}),
                    new Questions("Какой тип данных отвечает за целые числа?", new String[] {"String", "Float", "Boolean", "Integer"}),
                    new Questions("Как правильно объявить многомерный массив", new String[] {"a(0)(0) = 1;", "a[0 0] = 1;", "a{0}{0} = 1;", "a[0][0] = 1;"}),
                    new Questions("Какой метод запускает программу?", new String[] {"Основного метода нет", "Первый объявленный метод", "Любой, конкретного метода нету", "С метода main в любом из классов"}),
                    new Questions("Каждый файл должен иметь название", new String[] {"Соответствующий первой подключенной библиотеке", "Соответствующий первой функции", "Соответсвующий типам данных, хранящихся в нем", "Соответствующий имени класса, хранящегосяв нем"}),
                    new Questions("Сколько параметров может принимать функция?", new String[] {"Десять", "В Java функции не принимают параметров", "Пять", "Количество не определено"})
            };

    private Questions[] ciPlusPlusQuestions = new Questions[]
            {
                    new Questions("Как ваше настроение?", new String[] {"Не очень", "Плохо", "Могло быть лучше", "Боевое" }),
                    new Questions("Как вывести информацию на экран?", new String[] {"Console.Write()", "console.log()", "System.out.println()", "cout;" }),
                    new Questions("Переменная int:", new String[] {"Вещественная переменная", "Символьная строка", "Логическая переменная", "Целая переменная"}),
                    new Questions("Переменная float:", new String[] {"Целая переменная", "Логическая переменная", "Символьная строка", "Вещественная переменная;"}),
                    new Questions("Что такое this", new String[] {"Указатель на начало массива", "Указатель на конец массива", "Такого оператора в C++ нет", "Указатель на текущий обьект"}),
                    new Questions("Как импортировать заголовки файлов:", new String[] {"#import", "#open", "#create", "#include"}),
                    new Questions("Выберите оператор ввода:", new String[] {"print(x)", "x=4", "x*5","cin>>"})
            };


    private Questions[] databaseQuestions = new Questions[]
            {
                    new Questions("Как ваше настроение?", new String[] {"Не очень", "Плохо", "Могло быть лучше", "Боевое" }),
                    new Questions("Как организовать связь Many-To-Many", new String[] {"Соединить PK двух таблиц", "Соединить FK двух таблиц", "CREATE MANY-TO-MANY", "Создать связующую таблицу" }),
                    new Questions("Что такое PK:", new String[] {"Внеший ключ", "Вторичный ключ", "Повторный ключ", "Первичный ключ"}),
                    new Questions("Переменная FK:", new String[] {"Первичный ключ", "Вторичный ключ", "Повторный ключ", "Внешний ключ"}),
                    new Questions("Для чего нужно использовать ORDER BY", new String[] {"Для поиска", "Для вывода", "Для отбора записей из таблицы", "Для Сортировки"}),
                    new Questions("Какой параметр необходим для сортировки по возрастанию:", new String[] {"DESC", "UP", "DOWN", "ASC"}),
                    new Questions("Какой параметр необходим для сортировки по убыванию:", new String[] {"UP", "DOWN", "ASC", "DESC"}),
            };

    private Questions[] hrManagerQuestions = new Questions[]
            {
                    new Questions("Как ваше настроение?", new String[] {"Не очень", "Плохо", "Могло быть лучше", "Боевое" }),
                    new Questions("Какому уровню английского соответсует B2", new String[] {"Средний", "Начальный", "Носитель", "Выше среднего" }),
                    new Questions("Сколько длится рабочий день:", new String[] {"5 часов", "6 часов", "9 часов", "8 часов"}),
                    new Questions("Какая минимальный зарплата в РБ:", new String[] {"300,23р.", "332,13р.", "502,42р.", "483,17р."}),
                    new Questions("Cколько будет 32*2", new String[] {"66", "68", "43", "64"}),
                    new Questions("С какого возраста можно подписывать договор о трудоустройстве:", new String[] {"16", "14", "20", "18"}),
                    new Questions("Что значит 'Sory I'm bussy':", new String[] {"До свидания!", "Здравствуйте!", "Как дела?", "Я занят."}),
            };













    public void startQuiz(Questions[] type_of_questions)
    {


        //System.out.println(getJavaQuestions());
        if (getJavaQuestions() == 1)
        {
            currentQuizName.setText("Тест по Java");


        }

        if (getPythonQuestions() == 1)
        {
            currentQuizName.setText("Тест по Python");
        }

        if (getDatabaseQuestions() == 1)
        {
            currentQuizName.setText("Тест по базам данных");
        }

        if (getCiPlusPlusQuestions() == 1)
        {
            currentQuizName.setText("Тест по С++");
        }

        if (getHrManagerQuestions() == 1)
        {
            currentQuizName.setText("Тест Рекрутера");
        }




        nowCorrectAnswer = type_of_questions[nowQuestion].correctAnswer();

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
                if(nowQuestion + 1 == type_of_questions.length) {
                    radio_btn_1.setVisible(false);
                    radio_btn_2.setVisible(false);
                    radio_btn_3.setVisible(false);
                    radio_btn_4.setVisible(false);
                    answerBtn.setVisible(false);

                    question_text.setText("Вы правильно ответили на " + (correctAnswers - 1) + " из " + (type_of_questions.length - 1)  + " вопросов!");
                } else {
                    nowQuestion++;
                    nowCorrectAnswer = type_of_questions[nowQuestion].correctAnswer();

                    question_text.setText(type_of_questions[nowQuestion].getQuestion());
                    String[] answers = type_of_questions[nowQuestion].getAnswers();


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




    @FXML
    public void initialize()
     {
            /* nowCorrectAnswer = questions[nowQuestion].correctAnswer();

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
        });*/


         if (getJavaQuestions() == 1)
         {
             startQuiz(javaQuestions);


         }

         if (getPythonQuestions() == 1)
         {
             startQuiz(pythonQuestions);
         }

         if (getDatabaseQuestions() == 1)
         {
             startQuiz(databaseQuestions);
         }

         if (getCiPlusPlusQuestions() == 1)
         {
             startQuiz(ciPlusPlusQuestions);
         }

         if (getHrManagerQuestions() == 1)
         {
             startQuiz(hrManagerQuestions);
         }








     }

}
