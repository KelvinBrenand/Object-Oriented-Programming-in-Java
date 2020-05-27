public class MinMaxAccount extends BankingAccount {
    public MinMaxAccount(Startup s){
        super(s);
    }

    @Override
    public void debit(Debit d) {
        super.debit(d);
    }

    @Override
    public void credit(Credit c) {
        super.credit(c);
    }

    @Override
    public int getBalance() {
        return super.getBalance();
    }

    public int getMin(){
        String s = cleaner(historyBalanceToString());
        String m = "";
        double d, min = 0.0;
        boolean b = true;
        
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '-'){
                m = s.substring(i, i+5);
                i += 4;
            }else {
                m = s.substring(i, i+4);
                i += 3;
            }
            d = Double.parseDouble(m);
            if (b){
                min = d;
                b = false;
            }
            if (d < min){
                min = d;
            }
        }
        min = min * 100;
        return (int) min;
    }

    public int getMax(){
        String s = cleaner(historyBalanceToString());
        String m = "";
        double d, max = 0.0;
        boolean b = true;
        
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '-'){
                m = s.substring(i, i+5);
                i += 4;
            }else {
                m = s.substring(i, i+4);
                i += 3;
            }
            d = Double.parseDouble(m);
            if (b){
                max = d;
                b = false;
            }
            if (d > max){
                max = d;
            }
        }
        max = max * 100;
        return (int) max;
    }
    
    public String cleaner(String s){
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++){
            if (sb.charAt(i) == '$' || sb.charAt(i) == ' ' || sb.charAt(i) == '\n'){
                sb.deleteCharAt(i);
                i--;
            }
        }
        s = sb.toString();
        return s;
    }
}
