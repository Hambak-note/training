package codemanipulation.thejava.bytecode_manipulate;

public class Masulsa {

    public static void main(String[] args)  {
        System.out.println(new Moja().pullOut());





//        //문자열에 부터 참조하도록
//        ClassLoader classLoader = Masulsa.class.getClassLoader();
//        TypePool typePool = TypePool.Default.of(classLoader);
//
//        try{
//            new ByteBuddy().redefine(
//                    typePool.describe("codemaniplulation.thejava.bytecode_manipulate.Moja").resolve(),
//                            ClassFileLocator.ForClassLoader.of(classLoader))
//                    .method(named("pullOut")).intercept(FixedValue.value("Rabbit!"))
//                    .make().saveIn(new File("C:\\Study\\training\\Java\\the-java\\target\\classes"));
//        } catch(IOException e){
//            e.printStackTrace();
//        }

//        try{
//            new ByteBuddy().redefine(Moja.class)
//                    .method(named("pullOut")).intercept(FixedValue.value("Rabbit!"))
//                    .make().saveIn(new File("C:\\Study\\training\\Java\\the-java\\target\\classes"));
//        } catch(IOException e){
//            e.printStackTrace();
//        }


      //  System.out.println(new Moja().pullOut());
    }
}
