// prob: https://www.acmicpc.net/problem/7568

package backjoon.back7568;

import java.util.ArrayList;
import java.util.List;

public class Back7568 {

    public List<Integer> createGrades(List<Person> people) {
        List<Integer> grades = new ArrayList<>();
        for (int i = 0; i < people.size(); i++) {
            grades.add(1);
        }
        for (int i = 0; i < people.size(); i++) {
            int grade = 1;
            Person person = people.get(i);
            for (int j = 0; j < people.size(); j++) {
                if (i == j) {
                    continue;
                }
                Person cmpPerson = people.get(j);
                if (isBigPerson(person, cmpPerson)) {
                    grade++;
                }
            }
            grades.set(person.getId(), grade);
        }
        return grades;
    }

    private boolean isBigPerson(Person person, Person cmpPerson) {
        return cmpPerson.getHeight() > person.getHeight()
            && cmpPerson.getWeight() > person.getWeight();
    }
}
