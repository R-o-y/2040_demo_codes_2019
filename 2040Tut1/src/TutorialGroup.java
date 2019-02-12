public interface TutorialGroup {
    /* get this tutorial group's name e.g. "T05" */
    String getGroupNum();

    /*
     * get Student name at specified sNo, i.e. position in classlist
     */
    String getStudentAt(int sNo);

    /*
     * add Std. name after the last Student (including any dummies)
     */
    void addStudent(String student);

    /*
     * replace Std. name at given sNo if that posn. is within classlist; * otherwise
     * pad dummy Student(s) with name "" (empty String)
     */
    void setStudentAt(int sNo, String newStudent);

    /*
     * truncate classlist to given size without reordering any Student; will not
     * expand the classlist
     */
    void shrinkClassSize(int newSize);

    /*
     * return representation of class list with the format below: e.g.
     * "[1:Ridi, 2:Van, 3:Abdul, 4:Samuel, 5:, 6:Ian, 7:, 8:]"
     */
    @Override
    String toString();
}