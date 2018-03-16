public class ReplaceBlank {
    static String replace(String str) {
        if(str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                sb.append('%');
                sb.append('2');
                sb.append('0');
            }else {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "We are happy.";
        System.out.println(replace(str));
    }
    
}