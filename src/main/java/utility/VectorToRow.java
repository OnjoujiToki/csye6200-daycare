package utility;

import edu.neu.csye6200.*;

import java.util.*;

public class VectorToRow {

    public static List<Vector<Object>> convertStudentvector(Vector<Student> vector){

        List<Vector<Object>> templist = new ArrayList<>();

        for(Student student:vector){
            Vector<Object> tempvector = new Vector<>();
            tempvector.add(student.getId());
            tempvector.add(student.getName());
         //   tempvector.add(student.getAge());
            tempvector.add(student.getParent());
            tempvector.add(student.getEmail());
         //   tempvector.add(student.getTeacher().getName());
            tempvector.add(student.Grades.getMath());
            tempvector.add(student.Grades.getEnglish());
            tempvector.add(student.Grades.getChemistry());
            tempvector.add(student.Grades.getPhysics());
            tempvector.add(student.Grades.getJava());
            tempvector.add(student.Grades.getMusic());

            templist.add(tempvector);

        }
        return templist;

    }
    public static List<Object> convertTeachervector(Vector<Teacher> vector){

        List<Object> templist = new ArrayList<>();

        for(Teacher teacher:vector){
            Vector<Object> tempvector = new Vector<>();
            tempvector.add(teacher.getId());
            tempvector.add(teacher.getName());
            tempvector.add(teacher.getAge());
            tempvector.add(teacher.getEmail());
            tempvector.add(teacher.getClassroom());

            templist.add(tempvector);

        }
        return templist;

    }

}
