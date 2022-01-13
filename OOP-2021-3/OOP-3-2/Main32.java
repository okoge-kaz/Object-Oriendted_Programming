import oop.ex32.Person;

class Main32 {
  public static void main(String[] args) {
    Person mori = new Person("Sosuke", "Moriguchi");

    Person mo = new Person("So", "Mori");
    System.out.println(mori + " =? " + mo + " : " + mori.equals(mo));

    mo = new Person("So", "Moriguchi");
    System.out.println(mori + " =? " + mo + " : " + mori.equals(mo));

    mo = new Person("Sosuke", "Mori");
    System.out.println(mori + " =? " + mo + " : " + mori.equals(mo));

    mo = new Person("Sosuke", "Moriguchi");
    System.out.println(mori + " =? " + mo + " : " + mori.equals(mo));

    System.out.println(mori.hashCode());
    System.out.println(mo.hashCode());
  }
}
