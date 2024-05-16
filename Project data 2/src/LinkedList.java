public class LinkedList {
    private Polynomial head;
    private int size;
    LinkedList(){
        head = null;
        size = 0;
    }
    public int getSize() {
        return size;
    }
    public void Evaluate(double x){
        Polynomial currentTerm = head;
        double result = 0;
        while (currentTerm!=null){
            result+=currentTerm.getCofficient()*Math.pow(x,currentTerm.getExponent());
            currentTerm = currentTerm.next;
        }
        System.out.println("Result Of Polynomial is :" + result);

    }
    public void AddTerm(double coff,int exp){
        Polynomial newTerm = new Polynomial(coff,exp);
        if (head == null){
            head = newTerm;
        }
        else
        {
            Polynomial currentTerm = head;
            Polynomial previousTerm = null;
            while (currentTerm.getExponent()>exp && currentTerm.next != null)
            {
                previousTerm = currentTerm;
                currentTerm = currentTerm.next;
            }
            if (currentTerm.getExponent() == exp)
            {
                currentTerm.setCofficient(currentTerm.getCofficient() + coff);
            }
            else if (currentTerm.getExponent() < exp) {
                if (previousTerm == null){
                    newTerm.next = head;
                    head = newTerm;
                }
                else
                {
                    previousTerm.next = newTerm;
                    newTerm.next = currentTerm;
                }
            }
            else
            {
                currentTerm.next = newTerm;
            }
        }
        size ++;
    }
    public void Display(){
        Polynomial currentTerm = head;
        while (currentTerm.next != null) {
            System.out.print(currentTerm.getCofficient() + "x^" + currentTerm.getExponent() + " + ");
            currentTerm = currentTerm.next;
        }
        System.out.print(currentTerm.getCofficient() + "x^" + currentTerm.getExponent());
        System.out.println();
    }
    public void Addition(LinkedList list){
        Polynomial currentTerm = head;
        Polynomial currentTerm2 = list.head;
        LinkedList newList = new LinkedList();
        while (currentTerm != null && currentTerm2 != null){
            if (currentTerm.getExponent() == currentTerm2.getExponent())
            {
                newList.AddTerm(currentTerm.getCofficient() + currentTerm2.getCofficient() , currentTerm.getExponent());
                currentTerm = currentTerm.next;
                currentTerm2 = currentTerm2.next;
            }
            else
            {
                newList.AddTerm(currentTerm.getCofficient(),currentTerm.getExponent());
                newList.AddTerm(currentTerm2.getCofficient(),currentTerm2.getExponent());
                currentTerm = currentTerm.next;
                currentTerm2 = currentTerm2.next;
            }
        }
        while (currentTerm != null || currentTerm2 != null)
        {
            if (currentTerm != null)
            {
                newList.AddTerm(currentTerm.getCofficient(),currentTerm.getExponent());
                currentTerm = currentTerm.next;
            }
            if (currentTerm2 != null)
            {
                newList.AddTerm(currentTerm2.getCofficient(),currentTerm2.getExponent());
                currentTerm2 = currentTerm2.next;
            }
        }
        newList.Display();
    }
    public void Subtraction(LinkedList list){
        Polynomial currentTerm = head;
        Polynomial currentTerm2 = list.head;
        LinkedList newList = new LinkedList();
        while (currentTerm != null && currentTerm2 != null){
            if (currentTerm.getExponent() == currentTerm2.getExponent())
            {
                newList.AddTerm(currentTerm.getCofficient() - currentTerm2.getCofficient() , currentTerm.getExponent());
                currentTerm = currentTerm.next;
                currentTerm2 = currentTerm2.next;
            }
            else
            {
                if (currentTerm.getExponent() > currentTerm2.getExponent())
                {
                    newList.AddTerm(currentTerm.getCofficient(),currentTerm.getExponent());
                    currentTerm = currentTerm.next;
                }
               else {
                    newList.AddTerm(0-currentTerm2.getCofficient(),currentTerm2.getExponent());
                    currentTerm2 = currentTerm2.next;
                }
            }
        }
        while (currentTerm != null || currentTerm2 != null)
        {
            if (currentTerm != null)
            {
                newList.AddTerm((currentTerm.getCofficient()),currentTerm.getExponent());
                currentTerm = currentTerm.next;
            }
            if (currentTerm2 != null)
            {
                newList.AddTerm((0-currentTerm2.getCofficient()),currentTerm2.getExponent());
                currentTerm2 = currentTerm2.next;
            }
        }
        newList.Display();
    }
    public void Multiply(LinkedList list) {
        LinkedList result = new LinkedList();
        Polynomial current = this.head;
        while (current != null) {
            Polynomial temp = list.head;
            while (temp != null) {
                double newCoefficient = current.getCofficient() * temp.getCofficient();
                int newExponent = current.getExponent() + temp.getExponent();
                result.AddTerm(newCoefficient, newExponent);
                temp = temp.next;
            }
            current = current.next;
        }
        result.Display();
    }
}
