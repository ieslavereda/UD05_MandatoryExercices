package es.ieslavereda.exercise2;

public class Password {

    public static final String UPPER_CASE="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWER_CASE=UPPER_CASE.toLowerCase();
    public static final String NUMBERS="0123456789";
    public static final String SIMBOLS="!$%&?@#";

    public static final int DEFAULT_LENGTH = 10;

    private int length;
    private String passwd;


    public Password(){
        this.length=DEFAULT_LENGTH;
        do{
            passwd = generatePassword(length,UPPER_CASE,LOWER_CASE,NUMBERS);
        }while (!isStrong());
    }
    public Password(int length){
        this.length = length;
        generatePassword();
    }
    public static String generatePassword(int size, String... template){
        StringBuilder passwd= new StringBuilder();
        StringBuilder text = new StringBuilder();

        for(String t : template)
            text.append(t);

        for(int i=0;i<size;i++){
            passwd.append(text.charAt((int) (Math.random() * text.length())));
        }
        return passwd.toString();
    }
    public void generatePassword(){
        passwd = generatePassword(length,UPPER_CASE,LOWER_CASE,NUMBERS);
    }

    public boolean isStrong(){

        int lower=0,upper=0,number=0;
        char c;

        for(int i=0;i<passwd.length();i++){
            c=passwd.charAt(i);
            if(UPPER_CASE.contains(Character.toString(c)))
                upper++;
            else if(LOWER_CASE.contains(Character.toString(c)))
                lower++;
            else if (NUMBERS.contains(Character.toString(c)))
                number++;
        }

        return lower>1 && upper>2 && number>4;
    }

    public int getLength() {
        return length;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setLength(int length) {
        this.length = length;
        //generatePassword();
    }

    @Override
    public String toString() {
        return passwd;
    }
}
