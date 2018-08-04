/**
 * @author Navin Kumar
 * @date 7/15/18
 *
 * Just for practicing hash
 * hash back to string does not work
 */
public class Hash {

    public static void main(String[] args) {
        String name = "NAVIN";
        int hash = 0;
        int shift = 26;

        int count = 0;
        for(char ch : name.toCharArray()) {
            hash = hash << 13;
            hash = hash + ch;
            count++;
        }

        System.out.printf("Hash of %s = %d\n", name, hash);

        StringBuilder builder = new StringBuilder();
        while (hash > 0) {
            count--;
            int div = (int) Math.pow(shift, count);
//            count--;
            System.out.println("div = " + div);
            int tmp = hash / div;
            System.out.println("tmp = " + tmp);
            hash = hash % div;
            System.out.println("hash = " + hash);
//            tmp = tmp / div;
            System.out.println("tmp = " + tmp);
            char ch = (char) tmp;
            System.out.println("Char = " + ch);
            builder.append(ch);
        }

        System.out.printf("Hash to str: %s\n", builder.toString());
    }
}
