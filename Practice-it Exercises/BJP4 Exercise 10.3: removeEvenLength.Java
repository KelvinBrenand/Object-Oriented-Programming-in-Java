public static void removeEvenLength(ArrayList<String> a){
        for (int i = a.size(); i > 0; i--){
            if (a.get(i-1).length() %2 == 0){
                a.remove(i-1);
            }
        }
}
