public static int maxLength(ArrayList<String> a){
        int maxLength = 0;
        for (int i = 0; i < a.size(); i++){
            if (a.get(i).length() > maxLength){
                maxLength = a.get(i).length();
            }
        }
        return maxLength;
    }
