public class Tutorials {
    public static void main(String[] args) {
        (new Tutorials()).runTest();
    }

    public void runTest() {
        TutorialGroup t05 = createT05(); // Diagrams 5, 1, 2
        System.out.println(t05.getGroupNum() + "| |" + t05.getStudentAt(4) + "| |" + t05.getStudentAt(7));

        t05.addStudent("Shiya");
        System.out.println(t05); // Diagram 3

        t05 = createT05();
        t05.setStudentAt(6, "Ivan");
        t05.setStudentAt(7, "Ranald"); // 4
        t05.setStudentAt(11, "Weiliang");
        System.out.println(t05);

        t05 = createT05();
        t05.shrinkClassSize(5);
        t05.shrinkClassSize(10); // Diagram 6
        System.out.println(t05);
    }

    private TutorialGroup createT05() {
        // interface used as ref. data type but object is an instance of
        TutorialGroup t05 = new TutorialGroupImpl("T05"); // the class
        t05.addStudent("Ridi");
        t05.addStudent("Van");
        t05.addStudent("Abdul");
        t05.addStudent("Samuel");
        t05.setStudentAt(6, "Ian");
        t05.setStudentAt(8, "");
        return t05;
    }
}