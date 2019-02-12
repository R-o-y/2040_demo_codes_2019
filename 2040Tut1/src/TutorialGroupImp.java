import java.util.ArrayList;

// public class TutorialGroupImp implements TutorialGroup {
// private String _groupName;

// public void TutorialGroup(String groupName) {
// this._groupName = groupName;
// }

// @Override
// public void addStudent(String student) {

// }

// @Override
// public String getGroupNum() {
// return this._groupName;
// }

// @Override
// public String getStudentAt(int sNo) {
// return "";
// }

// @Override
// public void shrinkClassSize(int newSize) {

// }

// @Override
// public void setStudentAt(int sNo, String newStudent) {

// }

// @Override
// public String toString() {
// return "";
// }
// }

class TutorialGroupImpl implements TutorialGroup {
    private String _groupNum;
    private ArrayList<String> _students;

    public TutorialGroupImpl(String groupNum) {
        _groupNum = groupNum;
        _students = new ArrayList<String>();
    }

    @Override
    public String getGroupNum() {
        return _groupNum;
    }

    @Override
    public String getStudentAt(int sNo) {
        return _students.get(sNo - 1);
    }

    @Override
    public void addStudent(String student) {
        _students.add(student);
    }

    @Override
    public void setStudentAt(int sNo, String newStudent) {
        if (sNo <= _students.size()) {
            _students.set(sNo - 1, newStudent); // convert to 0-based idx
            return;
        }
        for (int gap = _students.size() + 1; gap < sNo; gap++)
            _students.add(""); // dummy Student
        _students.add(newStudent);
    }

    @Override
    public void shrinkClassSize(int newSize) {
        while (newSize < _students.size()) // remove from back
            _students.remove(_students.size() - 1); // for efficiency
    }

    @Override
    public String toString() {
        if (_students.isEmpty()) // corner case: 0 elements
            return "[]";
        StringBuilder classList = new StringBuilder(); // for efficiency
        classList.append("[1:" + _students.get(0));
        for (int idx = 1; idx < _students.size(); idx++)
            classList.append(", " + (idx + 1) + ":" + _students.get(idx));
        classList.append("]");
        return classList.toString();
    }
}