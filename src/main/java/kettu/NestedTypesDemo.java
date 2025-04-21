package kettu;

public class NestedTypesDemo {

  private int value = 1;

  public NestedTypesDemo() {
    System.out.println("NestedTypesDemo constructor");
  }

  // --------------------------------------------------

  public static void runExamples() {
    innerClassExample();
    staticMemberClassExample();
    staticMemberInterfaceExample();
    staticMemberEnumExample();
    staticMemberRecordExample();
    nonStaticMethodExample();
  }

  // --------------------------------------------------

  public class InnerClass {

    private int value = 2;

    public InnerClass() {
      System.out.println("InnerClass constructor");
    }

    private void printValues() {
      System.out.println(NestedTypesDemo.this.value);
      System.out.println(value);
    }

  }

  private static void innerClassExample() {
    final NestedTypesDemo outerClassObject = new NestedTypesDemo();
    final InnerClass innerClassObject = outerClassObject.new InnerClass();
    innerClassObject.printValues();
  }

  // --------------------------------------------------

  public static class StaticMemberClass {

    public StaticMemberClass() {
      System.out.println("StaticMemberClass constructor");
    }

  }

  private static void staticMemberClassExample() {
    final StaticMemberClass staticMemberClassObject = new StaticMemberClass();
    System.out.println(staticMemberClassObject);
  }

  // --------------------------------------------------

  // implicitly static
  public interface StaticMemberInterface {
    void interfaceMethod();
  }

  private static void staticMemberInterfaceExample() {
    final StaticMemberInterface staticMemberInterface = new StaticMemberInterface() {
      public void interfaceMethod() {
        System.out.println("StaticMemberInterface interfaceMethod");
      }
    };
    staticMemberInterface.interfaceMethod();
  }

  // --------------------------------------------------

  // implicitly static
  public enum StaticMemberEnum {
    ONE,
    TWO,
    THREE,
  }

  private static void staticMemberEnumExample() {
    final StaticMemberEnum enum1 = StaticMemberEnum.ONE;
    System.out.println(enum1);
    final StaticMemberEnum enum2 = StaticMemberEnum.TWO;
    System.out.println(enum2);
    final StaticMemberEnum enum3 = StaticMemberEnum.THREE;
    System.out.println(enum3);
  }

  // --------------------------------------------------

  // implicitly static
  public record StaticMemberRecord(String field1, String field2) {
  }

  private static void staticMemberRecordExample() {
    final StaticMemberRecord staticMemberRecord = new StaticMemberRecord("f1", "f2");
    System.out.println(staticMemberRecord);
  }

  // --------------------------------------------------

  private void nonStaticMethod() {
    class LocalClass {
    }
    final LocalClass localClass = new LocalClass();
    System.out.println(localClass);

    interface StaticLocalInterface {
    }
    final StaticLocalInterface staticLocalInterface = new StaticLocalInterface() {
    };
    System.out.println(staticLocalInterface);

    enum StaticLocalEnum {
      A, B, C,
    }
    final StaticLocalEnum staticLocalEnumA = StaticLocalEnum.A;
    final StaticLocalEnum staticLocalEnumB = StaticLocalEnum.B;
    final StaticLocalEnum staticLocalEnumC = StaticLocalEnum.C;
    System.out.printf("%s %s %s%n", staticLocalEnumA, staticLocalEnumB, staticLocalEnumC);

    record StaticLocalRecord(String fieldA, String fieldB, String fieldC) {
    }
    final StaticLocalRecord staticLocalRecord = new StaticLocalRecord("fieldA", "fieldB", "fieldC");
    System.out.println(staticLocalRecord);
  }

  private static void nonStaticMethodExample() {
    final NestedTypesDemo nestedTypesDemo = new NestedTypesDemo();
    nestedTypesDemo.nonStaticMethod();
  }

}
