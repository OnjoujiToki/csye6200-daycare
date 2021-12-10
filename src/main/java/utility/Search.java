package utility;

import edu.neu.csye6200.*;

public class Search {

    public static AbstractPerson search(String type, String name){

        switch(type){

            case("teacher"):{
                for (Teacher teacher:School.getTeachers()){
                    if (teacher.getName()==name){
                        return teacher;
                        break;
                    }
                }
            }
            case("student"):{
                for (Student student:School.getStudents()){
                    if (student.getName()==name){
                        return student;
                        break;
                    }
                }
            }
        }
    }
}
