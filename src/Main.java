public class Main {
    private static void yep(String arg1, String arg2, int arg3) {
        String text = String.format("Arg1=%s, Arg2=%s, Arg3=%d", arg1, arg2, arg3);
        System.out.println(text);
    }

    public static void main(String[] args) {
        yep("Yep", "Nope", 25565);
    }
}