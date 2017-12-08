public class hello{
   public static void main (String args[]){
   System.out.println("大家好！");
   System.out.println("很高兴见到你");
   Student stu =new Student();
   stu.speak("We  are  students");

}
}
  class Student{
    public void speak(String s){
    System.out.println(s);

}


}