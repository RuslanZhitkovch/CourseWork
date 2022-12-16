package com.example.coursework;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionRepositoryImpl implements QuestionRepository
{








    Connection connection = DBHandler.getConnection();

    @Override
    public List<Question> getAllQuestions()
    {
        List<Question> questions;
        try {
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM questions";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            questions = new ArrayList<>();

            while (resultSet.next()) {
                Question question = new Question(resultSet.getInt("id_question"),
                        resultSet.getString("question"),
                        resultSet.getString("answer1"),
                        resultSet.getString("answer2"),
                        resultSet.getString("answer3"),
                        resultSet.getString("answer4"),
                        resultSet.getString("correct_answer"),
                        resultSet.getInt("job_title_code")



                );
                questions.add(question);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return questions;




    }

}
