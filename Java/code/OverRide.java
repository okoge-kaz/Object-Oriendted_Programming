class OverRide {
  public static void main(String[] args) {
    class X {
      void method(){
        System.out.println("x");
      }
    }
    class Y extends X {
      @Override
      void method(){
        System.out.println("y");
      }
    }

    X x; Y y;
    x = new Y();
    x.method();// y

    x = new X();
    x.method();// x

    y = new Y();
    y.method();// y

    // y = new X();
    // y.method();
  }
}
