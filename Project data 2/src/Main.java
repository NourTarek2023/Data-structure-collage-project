public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.AddTerm(1, 1);
        list.AddTerm(1, 0);
        //list.AddTerm(4, 0);
        //list.AddTerm(1, 4);
        //list.AddTerm(1, 5);
        //list.Display();

        LinkedList list1 = new LinkedList();
        list1.AddTerm(1,1);
        list1.AddTerm(1,0);
        //list1.AddTerm(6,0);
        //list1.AddTerm(1,2);
       // list1.AddTerm(1,4);
        list.Addition(list1);
        list.Subtraction(list1);
        list1.Subtraction(list);
        list.Multiply(list1);
        list.Evaluate(2);

    }
}