public class Encription {

    public String key;
    public String plaintxt;
    public int orginalLength;
    private String encrypted = "";

    public String getEncrypted() {
        return encrypted;
    }

    public String getDecrypted() {
        return decrypted;
    }

    private String decrypted = "";

    public Encription(String key, String plaintxt){
        this.orginalLength = plaintxt.length();
        this.key = key;
        this.plaintxt = plaintxt;
        int length = key.length();
        if(this.key.length()<this.plaintxt.length()) {
            for (int i = length - 1; i < plaintxt.length() - 1; i++) {
                this.key += this.key.charAt(i - length + 1);
            }
        }else if(this.key.length()>this.plaintxt.length()){
            for(int i = this.plaintxt.length()-1; i<this.key.length();i++){
                plaintxt += 'z';
            }
        }
        encrypt();
        decrypt();
    }

    public void encrypt(){
        for(int i =0; i<plaintxt.length(); i++)
            encrypted += (char)((((plaintxt.charAt(i)-'a')+(key.charAt(i)-'a'))%26)+'a');
    }

    public void decrypt(){
        for(int i =0; i<plaintxt.length(); i++)
            decrypted += (char)((((encrypted.charAt(i)-'a')-(key.charAt(i)-'a') +26)%26)+'a');
    }
	


}
