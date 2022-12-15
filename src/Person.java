import java.io.*;

class Person implements Serializable{
   private static final long serialVersionUID = 1L;
   private String name;
   private int age;

   Person() {
   };

   Person(String name, int age) {
       this.name = name;
       this.age = age;
   }

   @Override
   public String toString() {
       return "Person [Name=" + name + ", age: " + age+"]";
   }
}